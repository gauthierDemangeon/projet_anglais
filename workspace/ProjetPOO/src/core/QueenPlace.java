package core;

public class QueenPlace extends Place {

	private Place p;
	public QueenPlace(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void setQueenPlace(Place place)
	{
		this.p = place;
	}
	public Bee[] getBees() {
        Bee[] bees1 = super.getBees();
        if (p != null) {
            Bee[] bees2 = p.getBees();
            Bee[] bees3 = new Bee[bees1.length + bees2.length];

            for (int i = 0; i < bees1.length; i++) {
                bees3[i] = bees1[i];
            }
            for (int i = 0; i < bees2.length; i++) {
                bees3[i + bees1.length] = bees2[i];
            }
            return bees3;
        } else {
            return bees1;
        }
    }

}
