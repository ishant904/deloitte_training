package shapes;

public class Square extends Shape {

	

	public Square(double length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computeArea() {
		// TODO Auto-generated method stub
		System.out.println("Area"+ length*length);

	}

	@Override
	public void computePerimeter() {
		// TODO Auto-generated method stub
		System.out.println("Perimeter"+2*length);

	}

	@Override
	public String toString() {
		return "Square"+length;
	}
	
	

}
