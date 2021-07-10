<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/7/4
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>protorypeTest</title>
    <script type="text/javascript">
       /* function Person(name,age){
            this.name=name;
            this.age=age;
        }

        person = new Person();
        console.log(Person.prototype);
        console.log(person.__proto__);*/


       function Person(name,age) {
           this.name=name;
           this.age=age;
       }
       var person = new Person("李华",19);
       console.log(person.__proto__ === Person.prototype);  //true?
    </script>
</head>
<body>

</body>
</html>
