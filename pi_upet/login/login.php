<?php
    session_start();
    unset($_SESSION['msg']);
    require_once "../util/config.php";
    if ($_SERVER['REQUEST_METHOD'] == "POST"){
        $email = $_POST["email"];
        $senha = $_POST["senha"];

        $sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "ss", $email, $senha);
        mysqli_stmt_execute($stmt);
        $result = mysqli_stmt_get_result($stmt);
        $row = mysqli_fetch_array($result);
        if(mysqli_num_rows($result) > 0){
            header('location: ../user-conectado/perfil.php');
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
    <title>Tela de login</title>
    
    <link rel="stylesheet" href="../css/login.css">
    <link rel="shortcut icon" href="../upet.ico">
</head>
<body>
    <header class="menu-principal">
        <main>
            <div class="header-1">
                <div class="logo">
                    <a href="../index.php"><img src="../img/logo_upet.png"/></a>
                </div>
                <div class="menu-secao">
                    <ul>
                        <li><a href="../alimentos.php">Alimentos</a></li>
                        <li><a href="../acessorios.php">Acessórios</a></li>
                        <li><a href="../brinquedos.php">Brinquedos</a></li>
                        <li><a href="../higiene.php">Saúde e Higiene</a></li>
                    </ul>
                </div>
            </div>
        </main>
    </header>

    <div class="centro">
        <div class="posicao">
            <ul>
                <li>
                    <div class="imagem">
                        <img src="../img/Dog.png" id="cachorro">
                    </div>
                </li>
                <li>
                    <div class="login-formulario">
                        <form method="POST">
                        <div class="login">
                            <div class="titulos">
                                <p class="login-titulo">Login</p>
                                <p class="login-subtitulo">Acesse sua conta</p>
                            </div>
                            <input type="text" name="email" placeholder="Nome do usuário" class="input-login">
                            <br><br>
                            <input type="password" name="senha" placeholder="Senha" class="input-login">
                            <br><br>
                            <button type="submit" id="botao-login">Entrar</button><br><br>
                            <br>
                            <div class="login-cadastro">
                                <p class="texto-login">Não tem uma conta? <br><a href="../cliente/create.php">Cadastre-se</a></p>
                            </div>
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
                </li>
            </ul>
        </div>
    </div>
</body>
</html>