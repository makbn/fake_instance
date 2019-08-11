## Fake Instance Generator

I just start to implement a webservice for my new own project and i need to create business layer
for the front-end team to develop clients in parallel! fastest way is to generate fake data!

## How to use

  1. annotate your model:
  ```java
  public static class Person {
  
          @Username(containsNumber = true)
          private String username;
  
          @Email(provider = Email.Provider.Hotmail)
          private String email;
  
          @Name(gender = Name.Gender.Male)
          private String name;
  
          @Phone
          private String phone;
  
          @Password
          private String password;
  
          @Number(negative = true)
          private int num;
  
          @Address
          private String address;
  
          @Text(equalOrShorterThan = 30)
          private String text;
  
          @City
          private String city;
  
          @Country
          private String country;
  
  
          public String getUsername() {
              return username;
          }
  
          public void setUsername(String username) {
              this.username = username;
          }
  
          public String getEmail() {
              return email;
          }
  
          public void setEmail(String email) {
              this.email = email;
          }
  
          public String getName() {
              return name;
          }
  
          public void setName(String name) {
              this.name = name;
          }
          
      }
  ```
  
  2. generate fake data:
  ```
  Person p = FakeInstance
                    .get()
                    .createAndFill(Person.class, 1);
  
        
  ```
  
