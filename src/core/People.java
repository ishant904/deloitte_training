package core;

public class People {
	
	private Person[] persons;
	int pers=5;
	int counter=0;
	
	public People() {
		persons =new Person[pers];
	}
	
	public void addPerson(Person p) {
		persons[counter++]=p;
	}
	
	public void displayPersons() {
		for(Person p:persons) {
			System.out.println(p);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People ppl = new People();
		ppl.addPerson(new Person("amit",9845327567L));
		ppl.addPerson(new Person("asha",9845327568L));
		ppl.addPerson(new Person("rupa",9845327569L));
		ppl.addPerson(new Person("shahji",9845327562L));
		ppl.addPerson(new Person("nani",9845327561L));
		ppl.displayPersons();

	}

}
