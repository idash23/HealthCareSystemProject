<?php
    $username = $_POST['username'];
    $password = $_POST['password'];
    $con = mysqli_connect("ocu-mysql-capstone.mysql.database.azure.com", "ocucapstone@ocu-mysql-capstone", "Gg21EL$#8w!K", "HealthCareDB");

    $stmt = $con->prepare("SELECT password FROM user WHERE email = ?;");
    $stmt->bind_param("s", $username);
    $stmt -> execute();

    if($password == $stmt){
        echo "Successfully logged in";
    } else {
        echo "Wrong email or password";
    }

?>