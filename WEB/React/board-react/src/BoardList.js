import React from "react";

class BoardHeading extends React.Component {

    render() {
        return (<thead><tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
        </tr></thead>);
    }

}

class BoardLine extends React.Component {

    render() {
        let table = this.props.data.map(function (item) {
            return <tr key={item.seq}>
                <td>{item.seq}</td>
                <td>{item.title}</td>
                <td>{item.writer}</td>
                <td>{item.view}</td>
            </tr>;
        });
        return <tbody>{table}</tbody>;
    }
}

class BoardList extends React.Component {

    board = [
        { seq: "1", title: "제목1", writer: "작성자1", view: "10" },
        { seq: "2", title: "제목2", writer: "작성자2", view: "11" },
        { seq: "3", title: "제목3", writer: "작성자3", view: "30" },
        { seq: "4", title: "제목4", writer: "작성자4", view: "55" },
        { seq: "5", title: "제목5", writer: "작성자5", view: "0" }
    ];

    render() {
        return (<table border="3">
            <BoardHeading />
            <BoardLine data={this.board} />
        </table>);
    }

}
export default BoardList;