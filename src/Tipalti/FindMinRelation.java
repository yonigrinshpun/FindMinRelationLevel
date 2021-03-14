package Tipalti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinRelation {

    public ArrayList<Person> personsList = new ArrayList<Person>();


    public static void main(String[] args) {
        FindMinRelationImplementation rt = new FindMinRelationImplementation();
        rt.callTest();
    }

}
    class FindMinRelationImplementation {
        public ArrayList<Person> personsList = new ArrayList<Person>();
        void callTest(){
            Name namePerson1 = new Name("Alan", "Turing");
            Name namePerson2 = new Name("Joan", "Clarke");
            Name namePerson3 = new Name("Grace", "Hopper");
            Name namePerson4 = new Name("Yoni", "Grinshpun");
            Address addPerson1 = new Address("Cambridge","");
            Address addPerson2 = new Address("London","");
            Address addPerson3 = new Address("Bletchley Park","");
            Address addPerson4 = new Address("New York","");

            Person person1 = new Person(namePerson1,addPerson1);
            Person person2 = new Person(namePerson1,addPerson3);
            Person person3 = new Person(namePerson2,addPerson3);
            Person person4 = new Person(namePerson2,addPerson2);
            Person person5 = new Person(namePerson4,addPerson4);


            Person testPersonList[] = new Person[] {person1, person2, person3, person4, person5};

            System.out.printf("-------------------------------\n");

            Init(testPersonList);
//  ----------------------------- Run Finding function for Testing ----------------------------------
            int minConnections = FindMinRelationLevel(person1, person4);


            System.out.printf("Minimal of relation: " + minConnections);
        }

        public void Init(Person[] people) {
            personsList = new ArrayList<>(Arrays.asList(people));

        }

        // Return list of persons connected with 1- level relation for all persons in myList
        List<Person> closedRelation(List<Person> myList) {
            List<Person> relativesList = new ArrayList<Person>();
            for (Person currPerson : personsList) {
                for (Person myListPerson : myList) {
                    if (currPerson.FullName == myListPerson.FullName || currPerson.Address == myListPerson.Address) {
                        relativesList.add(currPerson);
                    }

                }
            }
            return relativesList;
        }


        int FindMinRelationLevel(Person personA, Person personB) {
            int k = -1;
            List<Person> relativesListB = new ArrayList<Person>();
            relativesListB.add(personB);

            for (int i = 0; i < personsList.size(); i++) {
                relativesListB = closedRelation(relativesListB);
                if (relativesListB.contains(personA)) {
                    return (i + 1);
                }
            }
            return -1;
        }
    }

    class Person
    {
        public Name FullName;
        public Address Address;

        public Person(Name fullName, Address address) {
            FullName = fullName;
            Address = address;
        }
    }
    class Name
    {
        public String FirstName;
        public String LastName;

        public Name(String firstName, String lastName) {
            FirstName = firstName;
            LastName = lastName;
        }
    }
    class Address
    {
        public String Street;
        public String City;

        public Address(String street, String city) {
            Street = street;
            City = city;
        }
    }

