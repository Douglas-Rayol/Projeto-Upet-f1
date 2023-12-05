<?php
  session_start();
  require_once "../util/config.php";
  if ($_SERVER['REQUEST_METHOD'] == "POST") {
  $nome = $_POST["nome"];
  $endereco = $_POST["endereco"];
  $telefone = $_POST["telefone"];
  $senha = $_POST["senha"];
  $email = $_POST["email"];
  $cpf = $_POST["cpf"];
  $cidade = $_POST["cidade"];
  $estado = $_POST["estado"];
  $cep = $_POST["cep"];
  
  $sql = "INSERT INTO cliente (nome, endereco, telefone, senha, email, cpf, cidade, estado, cep) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

  $stmt = mysqli_prepare($link, $sql);

  mysqli_stmt_bind_param($stmt, "sssssssss", $nome, $telefone, $endereco, $senha, $email, $cpf, $cidade, $estado, $cep);

  if (mysqli_stmt_execute($stmt)){
    $_SESSION['msg'] = " Cadastro com sucesso";
  } else {
    $_SESSION['msg'] = " Erro no cadastro";
  }
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Upet</title>
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
          <div class="cadastro-formulario">
            <p class="cadastro-titulo">Cadastro de Cliente</p>
            <p class="cadastro-subtitulo">Crie sua conta</p>
            <form method="POST" action="create.php" class="formulario">
              <div class="form-row">
                <div class="nomecadastro">
                  <input type="text" class="input-cadastro" name="nome" placeholder="Nome" required>
                </div>
                <br>
                <div class="col-md-4 mb-3">
                  <input type="text" class="input-cadastro" name="cpf" placeholder="CPF" required>
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
                <div class="form-row">
                  <div class="cidadecadastro">
                    <input type="text" class="input-cadastro" name="cidade" placeholder="Cidade" required>
                  </div>
                  <br>
                  <div class="col-md-3 mb-3">
                    <input type="text" class="input-cadastro" name="estado" placeholder="Estado" required>
                  </div>
                  <br>
                  <div class="col-md-3 mb-3">
                    <input type="text" class="input-cadastro" name="cep" placeholder="CEP" required>
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
                  </div>
                </div>
                <br>
                <p><button type="submit" id="botao-cadastro">Cadastrar</button></p>
                <div class="cadastro-login">
                  <p class="cadastro-login">Já tem uma conta? <br><a href="../login/login.php">Faça Login</a></p>  
                  <?php
                    if (isset($_SESSION['msg']) == true) {
                      echo "<div class='input-cad'>";
                      echo $_SESSION['msg'];
                      unset($_SESSION['msg']);
                      echo "</div>";
                    }
                  ?>
                </div>
            </form>
          </div>
        </li>
      </ul>
    </div>
  </div>
  </div>
</body>