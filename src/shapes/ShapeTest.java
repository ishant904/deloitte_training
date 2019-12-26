package shapes;

public class ShapeTest {
	
	public static void draw(Drawable d,Shape s) {
		d.draw(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s=new Rectangle(20, 10);
		s.computeArea();
		s.computePerimeter();
		System.out.println(s);
		Shape sq=new Square(10);
		sq.computeArea();
		sq.computePerimeter();
		System.out.println(sq);
		draw(new ShapeDrawer(),s);
		
		Drawable d=new Drawable() {

			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				if(s instanceof Rectangle)
					System.out.println("Drawing rectangle shape using my drawable");
				if(s instanceof Square)
					System.out.println("Drawing shape shape using my drawable");
			}
			
		};
		
		draw(d,s);
		
		draw(new MyDrawable(),sq);

	}
	
	static class MyDrawable implements Drawable{

		@Override
		public void draw(Shape s) {
			// TODO Auto-generated method stub
			if(s instanceof Rectangle)
				System.out.println("Drawing rectangle shape using my drawable");
			if(s instanceof Square)
				System.out.println("Drawing square shape using my drawable");
			
		}
		
		
		
	}

}
