$(document).ready(function() {
	// ajax(event): "send" or "open" 입력 / voiceMessage에 담긴 텍스트를 Chatbot에 전송
	function textquery(event) {
		let voiceMessage = $("#voiceMessage").val();
		$("#voiceMessage").val("");
		$("#chat").append("<h3 style='text-align: right'>" + voiceMessage + "</h3>");

		$.ajax({
			url: "/chatbottext",
			type: "POST",
			data: {
				"voiceMessage": voiceMessage,
				"event": event
			},
			dataType: "JSON",
			success: function(tq) {
				let out = "<h3 style='text-align: left'>CLOVA:<br>";
				let bubbles = tq.bubbles;
				let text = "";
				for (let b in bubbles) {
					if (bubbles[b].type == "text") {
						// Text
						out += bubbles[b].data.description + "</h3>";
						text = bubbles[b].data.description;
						if (bubbles[b].data.url != null) {
							out += "<h3><a href='" + bubbles[b].data.url + "'>바로가기</a></h3>";
						}
						if (text.startsWith("주문이 완료되었습니다.")) {
							let split = text.split(/\r\n|\r|\n|\s/);
							for (let sp in split) {
								console.dir("[" + sp + "]" + split[sp]);
							}
							let pizza = split[4];
							let size = split[6];
							let phone = "";
							if (split[12] == "로") {
								phone = split[11];
							} else {
								phone = split[11] + split[12] + split[13];
							}

							$.ajax({
								url: "/chatbotpizza",
								type: "POST",
								data: {
									"pizza": pizza,
									"size": size,
									"phone": phone
								},
								dataType: "TEXT",
								success: function(p) {
									$("#chat").append("<h3 style='text-align: left; background-color: yellow'>" + p + "</h3>");
								}
							});
						}
						console.log(out);
					} else if (bubbles[b].type == "template") {
						if (bubbles[b].data.cover.type == "image") {
							// Image
							out += bubbles[b].data.cover.title + "<br>";
							text = bubbles[b].data.cover.title;
							out += "<img src='" + bubbles[b].data.cover.data.imageUrl + "'></h3>";
						} else if (bubbles[b].data.cover.type == "text") {
							// Multi-link
							out += bubbles[b].data.cover.data.description;
							text = bubbles[b].data.cover.data.description;
							out += "<ul>";
							let contentTable = bubbles[b].data.contentTable;
							for (let c in contentTable) {
								out += "<li><a href='" + contentTable[c][0].data.data.action.data.url + "'>";
								out += contentTable[c][0].data.title + "</a></li>";
							}
							out += "</ul></h3>";
						}
					}
				}
				$("#chat").append(out);

				// tts(text): textquery()에서 발생하는 텍스트를 TTS 서비스에 전송하여 음성 파일을 생성하고 <audio>에 지정
				$.ajax({
					url: "/chatbottts",
					type: "POST",
					data: {
						"text": text
					},
					dataType: "JSON",
					success: function(tts) {
						$("#audio").attr("src", "/ai_images/" + tts.filename);
					}
				}); // .ajax
			}
		}); // .ajax
	} // function textquery()

	// 첫 접속시 웰컴메시지 표시를 위해 "open"으로 Chatbot 실행
	textquery("open");

	// 전송 버튼 클릭시 "send"로 Chatbot 실행
	$("#send").on("click", function() {
		textquery("send");
	});

	// 마이크 입력이 가능하면 마이크 동작 설정
	if (navigator.mediaDevices) {
		let record = document.getElementById("record");
		let stop = document.getElementById("stop");
		console.log("Supported");

		let constraints = {
			audio: true
		};

		let chunks = [];
		navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
			let mediaRecorder = new MediaRecorder(stream);

			// 녹음 버튼 클릭시 미디어레코더 시작
			record.onclick = function() {
				mediaRecorder.start();
				record.style.color = "white";
				record.style.background = "red";
			}

			// 완료 버튼 클릭시 미디어레코더 정지
			stop.onclick = function() {
				mediaRecorder.stop();
				record.style.color = "";
				record.style.background = "";
			}

			// 녹음 중에는 데이터를 chunks에 저장
			mediaRecorder.ondataavailable = function(e) {
				chunks.push(e.data);
			}

			// 녹음이 끝났을 때 동작 설정
			mediaRecorder.onstop = function() {
				// chunks의 녹음 데이터를 blob으로 변환
				let blob = new Blob(chunks, {
					"type": "audio/mp3"
				});

				// chunks의 녹음 데이터 초기화
				chunks = [];

				// 가상의 <form> 역할을 하는 객체
				let formData = new FormData();
				formData.append("audio", blob);

				// blob 데이터를 서버에 전송하여 파일로 저장
				$.ajax({
					url: "/chatbotaudio",
					type: "POST",
					data: formData,
					// 파일 외에 다른 데이터는 없음
					processData: false,
					contentType: false,
					dataType: "JSON",
					success: function(audio) {
						// 서버에 저장된 파일을 STT 서비스에 전송전달받은 텍스트를 Chatbot에 전송
						$("#voiceMessage").val(audio.text);
						textquery("send");
					}
				});
			}
		}).catch(function(err) {
			console.log("오류발생 ", err);
		});
	} // if
});