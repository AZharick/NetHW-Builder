public class Main {
   public static void main(String[] args) {
      Person mom = new Person.PersonBuilder()
              .setName("Анна")
              .setSurname("Вольф")
              .setAge(31)
              .setCity("Сидней")
              .build();
      Person son = mom.newChildBuilder(7)
              .setName("Антошка")
              .build();
      System.out.println("У " + mom + " есть сын, " + son);

      try {
         // Не хватает обязательных полей
         new Person.PersonBuilder().build();
      } catch (IllegalStateException e) {
         e.printStackTrace();
      }

      try {
         // Возраст недопустимый
         new Person.PersonBuilder().setAge(-100).build();
      } catch (IllegalArgumentException e) {
         e.printStackTrace();
      }
   }
}