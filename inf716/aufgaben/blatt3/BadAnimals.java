class BadAnimals {

	public static void printAnimalMoving(Animal a) {
        a.move();
	}

	public static void main(String[] args) {
		Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		Bird b = new Bird();
		Cheetah ch = new Cheetah();
		Sloth s = new Sloth();

		printAnimalMoving(a);
		printAnimalMoving(b);
		printAnimalMoving(d);
		printAnimalMoving(c);
		printAnimalMoving(ch);
		printAnimalMoving(s);
	}
}


class Animal {
    public void move() {
        System.out.println("I'm an Animal, I just move.");
    }
}

class Dog extends Animal {
    @Override
	public void move() {
		System.out.println("Dogs run.");
	}
}

class Cat extends Animal {
    @Override
	public void move() {
		System.out.println("Cats tiptoe.");
	}
}

class Bird extends Animal {
    @Override
	public void move() {
		System.out.println("Birds fly.");
	}
}

class Cheetah extends Animal {
    @Override
	public void move() {
		System.out.println("Cheetah sprint.");
	}
}

class Sloth extends Animal {
    @Override
	public void move() {
		System.out.println("Sloths don't move!");
	}
}
