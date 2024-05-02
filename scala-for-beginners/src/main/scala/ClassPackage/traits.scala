package ClassPackage

object traits {

    trait Animal {
      def carnivore
      def placeToLive
      def isMammal

    }

    trait Bird extends Animal{

    }

    class Dog extends Animal{
      def carnivore = println("I'm a domestic Animal")
      def placeToLive = println("In residential area")
      def isMammal = println("Yes I am")
    }

    class Lion extends Animal{
      def carnivore = println("I'm a wild Animal")
      def placeToLive = println("In forest area")
      def isMammal = println("Yes I am")
    }

    class Eagle extends Animal with Bird {
      def carnivore = println("I'm a bird")
      def placeToLive = println("In sky area")
      def isMammal = println("nah")
    }

    val dog = new Dog
    val lion = new Lion
    val eagle = new Eagle


}
