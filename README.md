### Class Diagram

```mermaid
classDiagram
    Member <|-- ApartementOwner
    Member <|-- Individual
    Member "1"--o"1" Membership : has
    Member : +int id
    Member : +String name
    Member : +int phonenum
    Member : +int()
    class ApartementOwner{
      +string apartementnum
    }
    class Individual{
      -string birthdate
    }
    class Membership{
      +string expirationdate
      +payment(double cost)
    }
            
```

### ER Diagram

```mermaid
erDiagram
          MEMBER ||--|| APARTEMENT-OWNER : is
          MEMBER ||..|| INDIVIDUAL : is
          MEMBER ||--|| MEMBERSHIP : "has"
          MEMBER{
            int id
            string name
            int phonenum
          }
          APARTEMENT-OWNER{
            int apartementnum
          }
          INDIVIDUAL{
            string birthdate
          }
          MEMBERSHIP{
            string expirationdate
          }
```
### Design Class Diagram for JavaFX and Database
```mermaid
classDiagram
    Member <|-- Individual
    Member <|-- ApartementOwner
    Member "1"--o"*" Membership : has
    Member o-- MemberDataModel : Data Modeling
    MemberDataModel <-- MemberFormController : Data Control
    MemberDataModel --> DBConnection : DB Connection
    MemberFormController <.. MemberForm : Form Control      

    class Member{
      <<abstract>>
      #IntegerProperty id
      #StringProperty name
      #StringProperty phonenum
      
      +IntegerProperty nextID()
    }
    
    class Individual{
      -StringProperty birthdate
    }
    class ApartementOwner{
      -StringProperty apartementnum
    }
    class Membership{
      -StringProperty expirationdate
      +renewmembership(string update)
    }

    class MemberDataModel{
        Connection conn
        addMember()
        getMemberships()
        nextMemberID()
        nextMembershipNumber()
    }

    class MemberFormController{
        initialize()
        handleClearIndividu()
        handleReloadIndividu()
        handleReloadOwner()
        handleSaveIndividu()
        handleSaveIndividu2()
        handleSaveOwner()
        handleSaveOwner2()

    }
    class DBConnection{
        - String USERNAME
        - String PASSWORD
        - String DB
        - String MYCONN
        getConnection()
        getConnection(String driver)
        createTable();
    }
            
```
