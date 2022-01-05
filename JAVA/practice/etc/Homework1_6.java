// 6. 컴퓨터 부품을 class로 작성하고 컴퓨터 부품을 조합하여
//    컴퓨터 class를 완성하시오

class Computer {

	CPU cpu = new CPU();
	GPU gpu = new GPU();
	RAM ram = new RAM();
	SSD ssd = new SSD();

}

class CPU {

	void compute() {}
}

class GPU {

	void draw() {}

}

class RAM {

	void load() {}

}

class SSD {

	void store() {}

}

public class Homework1_6 {

	public static void main(String[] args) {
		Computer c = new Computer();

		c.cpu.compute();
		c.ram.load();
		c.gpu.draw();
		c.ssd.store();
	}

}
