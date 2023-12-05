<?php
    require_once "../util/config.php";
    if ($_SERVER['REQUEST_METHOD'] == "POST"){
        $nome = $_POST["nome"];
        $telefone = $_POST["telefone"];
        $endereco = $_POST["endereco"];

        $sql = "INSERT INTO funcionario (nome, telefone, endereco) VALUES(?, ?, ?)";
        
        $stmt = mysqli_prepare($link, $sql);
        
        mysqli_stmt_bind_param($stmt, "sss", $nome, $telefone, $endereco);

        if(mysqli_stmt_execute($stmt)){
          $_SESSION['msg'] = "<center>Cadastro com sucesso";
        } else {
          $_SESSION['msg'] = "<center>Erro no cadastro";
        }
    }
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Funcionario</title>
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
            <img src="../img/Cat.png" id="gato">
          </div>
        </li>
        <li>
        <div class="cadastro-formulario"><br>
        <p class="cadastro-titulo">Cadastro de Funcionário</p><br><br>
        <form method="POST" action="create.php" class="formulario">
        <div class="form-row">
          <div class="nomecadastro">
            <input type="text" class="input-cadastro" name="nome" placeholder="Nome" required>
          </div>
          <br>
          <div class="input-group input-group-sm mb-3">
            <input type="text" class="input-cadastro" name="telefone" placeholder="Telefone" required>
          </div>
          <br>
          <div class="input-group input-group-sm mb-3">
            <input type="text" class="input-cadastro" name="email" placeholder="Email" required>
          </div>
          <br>
            <div>
              <input type="text" class="input-cadastro" name="endereco" placeholder="Endereço" required>
            </div>
            <br>
            <div class="col-md-3 mb-3">
              <input type="password" class="input-cadastro" name="senha" placeholder="Senha" required>
            </div>
            <br>
            <div>
              <input type="password" class="input-cadastro" name="confsenha" placeholder="Confirmar Senha" required>
            </div><br>
            <p><button type="submit" id="botao-cadastro">Cadastrar</button></p>
            </form>
            <?php
              if (isset($_SESSION['msg']) == true){
                echo "<div class='input-cadastro'>";
                echo $_SESSION['msg'];
                echo "</div>";
              }
            ?>
    <p><a href='index.php'>Voltar</a></p>
</body>
</html>