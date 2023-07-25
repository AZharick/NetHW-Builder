import java.util.Objects;

public class Person {
   private String name;
   private String surname;
   private String city;
   private int age = 0;

   private Person() {
   }

   private Person(String name, String surname) {
      this.name = name;
      this.surname = surname;
   }

   private Person(String name, String surname, int age) {
      this.name = name;
      this.surname = surname;
      this.age = age;
   }

   public boolean hasAddress() {
      return !this.city.isBlank();
   }

   public boolean hasAge() {
      return this.age != 0;
   }

   public void happyBirthday() {
      if (hasAge()) {
         this.age = getAge() + 1;
      }
   }

   @Override
   public String toString() {
      return "Person{" +
              "name='" + name + '\'' +
              ", surname='" + surname + '\'' +
              ", city='" + city + '\'' +
              ", age=" + age +
              '}';
   }

   //GnS ====================
   public String getName() {
      return name;
   }

   public String getSurname() {
      return surname;
   }

   public String getCity() {
      if (hasAddress()) {
         return city;
      } else {
         return "no address";
      }
   }

   public int getAge() {
      if (hasAge()) {
         return age;
      } else return 0;
   }

   public PersonBuilder newChildBuilder(int childAge) {
      PersonBuilder pb = new PersonBuilder()
              .setSurname(surname)
              .setAge(childAge)
              .setCity(city);
      return pb;
   }

   //========================================
   public static class PersonBuilder {
      private Person person;

      public PersonBuilder() {
         person = new Person();
      }

      public PersonBuilder setName(String name) {
         if (!Objects.equals(person.name, "")) {
            person.name = name;
         }
         return this;
      }

      public PersonBuilder setSurname(String surname) {
         if (!Objects.equals(person.surname, "")) {
            person.surname = surname;
         }
         return this;
      }

      public PersonBuilder setCity(String city) {
         person.city = city;
         return this;
      }

      public boolean hasAddress() {
         return !person.city.isBlank();
      }

      public boolean hasAge() {
         return person.age != 0;
      }

      public PersonBuilder setAge(int age) throws IllegalStateException {
         if ((age > 100) || (age <= 0)) {
            throw new IllegalArgumentException("Incorrect age!");
         }
         if (!this.hasAge()) {
            person.age = age;
         }
         return this;
      }

      public Person build() throws IllegalStateException {
         if (person.name == null) {
            throw new IllegalStateException("Name undefined!");
         }
         if (person.surname == null) {
            throw new IllegalStateException("Surname undefined!");
         }

         return person;
      }
   }

}