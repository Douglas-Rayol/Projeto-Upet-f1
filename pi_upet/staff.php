<?php
    session_start();
    unset($_SESSION['msg']);
    require_once "./util/config.php";
    if ($_SERVER['REQUEST_METHOD'] == "POST"){
        $email = $_POST["email"];
        $senha = $_POST["senha"];

        $sql = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "ss", $email, $senha);
        mysqli_stmt_execute($stmt);
        $result = mysqli_stmt_get_result($stmt);
        $row = mysqli_fetch_array($result);
        if(mysqli_num_rows($result) > 0){
            header('location: ./produto/index.php');
            $_SESSION['email'] = $row['email'];
            $_SESSION['senha'] = $row['senha'];
        }else{
            $_SESSION['msg'] = "Usuario ou senha inválido";
        }
    }
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exibir Produto</title>
    <link rel="stylesheet" href="../css/clien-func.css">
    <link rel="shortcut icon" href="../css/img/upet.ico">
    <link rel="stylesheet" type="text/css" href="./css/staff.css">
    <link rel="shortcut icon" href="./upet.ico">
</head>
<body>
<div class="tela">
    <div class="logo">
        <img src="./img/logo_upet.png" />
        STAFF
    </div>
    <div class="staff-form">
                <form method="POST">
                            <div class="login">
                                <div class="titulos">
                                    <p class="login-titulo">Login</p>
                                    <p class="login-subtitulo">Acesse sua conta</p>
                                </div>
                                <div class="input-login">
                                    <input type="text" name="email" placeholder="Nome do usuário">
                                </div>
                                <br><br>
                                <div class="input-login">
                                    <input type="password" name="senha" placeholder="Senha">
                                </div>
                                <br><br>
                                <button type="submit" id="botao-login">Entrar</button><br><br>
                                <br>
                            </div>
                                <?php
                                  if (isset($_SESSION['msg']) == true) {
                                    echo "<div class='input-login'>";
                                    echo $_SESSION['msg'];
                                    echo "</div>";
                                  }
                                  ?>
                </form>
    </div>
</div>




</body>
</html>