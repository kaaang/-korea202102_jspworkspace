package springbasic.cook;


//요리사가 사용할 프라이팬을 정의
public class ElectPan implements Pan{
	public void warm() {
		System.out.println("전기로 요리를 데워요");
	}
}
