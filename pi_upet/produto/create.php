<?php
    session_start();
    require_once "../util/config.php";
    if ($_SERVER['REQUEST_METHOD'] == "POST"){
        $nome = $_POST["nome"];
        $preco = $_POST["preco"];
        $descricao = $_POST["descricao"];
        $tipo = $_POST["racoes"];
        $imagem = $_FILES['imagem'];
        

        $path = $imagem["tmp_name"];
        $type = pathinfo($path, PATHINFO_EXTENSION);
        $data = file_get_contents($path);
        $base64 = 'data:image/' . $type . ';base64,' . base64_encode($data);

        $sql = "INSERT INTO produtos (nome, preco, descricao, tipo, imagem) VALUES(?, ?, ?, ?, ?)";
        
        $stmt = mysqli_prepare($link, $sql);
        
        mysqli_stmt_bind_param($stmt, "sdsss", $nome, $preco, $descricao, $tipo, $base64);

        if(mysqli_stmt_execute($stmt)){
            $_SESSION['msg'] = " Cadastro com sucesso";
        }else{
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
    <title>Sistema de Produto</title>
    <link rel="shortcut icon" href="../upet.ico">
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
    <!-- Nav -->
    <header class="menu-principal">
        <main>
            <div class="header-1">
                <div class="logo">
                    <a href="../index.php"><img src="../img/logo_upet.png"/></a>
                </div>
            </div>
        </main>
    </header>
    <!-- Fim Nav -->

    <!-- Formulário de cadastro -->
    <div class="posicao">
        <div class="centro-cadproduto">
            <ul>
                <li>
                    <div class="imagem">
                        <img src="../img/Dog.png" />
                    </div>
                </li>
                <li>
                    <div class="div-cadproduto">
                        <div class="cadproduto-formulario">
                            <form method="POST" action="create.php" enctype="multipart/form-data"><br>
                                <h1> Cadastro de Produto</h1><br>
                                <input type="text" name="nome" size="40" placeholder=" Nome do Produto" class="input-cadproduto"> &nbsp; &nbsp;
                                <input type="text" name="preco" placeholder=" R$" class="input-cadproduto"><br><br>
                                <input type="text" name="descricao" size="40" placeholder=" Descriçao do Produto" class="input-cadproduto" id="cadproduto-descricao"> &nbsp; &nbsp;<br><br>
                                <input type="file" name="imagem">
                                <br>
                                <label for="uf" class="">Tipos de Produtos:</label><br>
                                <select name="racoes" id="select" class="input-cadproduto">
                                        <option value="0" class="input-cadproduto">Selecionar</option>
                                        <option value="Alimento" class="input-cadproduto">Alimentos</option>
                                        <option value="Acessorio" class="input-cadproduto">Acessórios</option>
                                        <option value="Brinquedo" class="input-cadproduto">Brinquedos</option>
                                        <option value="Saude e Higiene" class="input-cadproduto">Saúde e Higiene</option>
                                </select><br><br>
                    
                                <input type="submit" value="Registrar" class="btn-cadproduto">
                                <?php
                                    if (isset($_SESSION['msg']) == true) {
                                        echo "<div class='input-cadastro'>";
                                        echo $_SESSION['msg'];
                                        unset($_SESSION['msg']);
                                        echo "</div>";
                                    }
                                ?>
                            </form>
                            <p><a href='index.php'>Voltar</a></p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>