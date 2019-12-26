package shapes;

public class ShapeDrawer implements Drawable{

	@Override
	public void draw(Shape s) {
		// TODO Auto-generated method stub
		if(s instanceof Rectangle)
			System.out.println("Drawing Rectangle");
		if(s instanceof Square)
			System.out.println("Drawing Square");
	}

}
