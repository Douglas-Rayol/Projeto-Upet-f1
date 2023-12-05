<?php
    session_start();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>uPet Brinquedos</title>
    <link rel="shortcut icon" href="upet.ico">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/estilo.css" />
    <link rel="shortcut icon" href="../upet.ico">
</head>
<body>
    <header>
        <main>
            <div class="logo">
                <a href="../index.php"><img src="../img/logo_upet.png" /></a>
            </div>
            <div class="buscar">
                <input type="text" placeholder="Pesquisar na Upet" />
                <img src="../img/buscar.png" />
            </div>
            <div class="conta"><a href="../login/login.php" class="conta">
                <img src="../img/profile.png" />
                Minha conta</a>
            </div>
        </main>
        <div class="secoes">
            <ul>
                <li><a href="alimentos.php">Alimentos</a></li>
                <li><a href="acessorios.php">Acessórios</a></li>
                <li><a href="brinquedos.php">Brinquedos</a></li>
                <li><a href="higiene.php">Saúde e Higiene</a></li>
            </ul>
        </div>
    </header>

    <!-- BRINQUEDOS -->
    <div class="produto-texto">
    <div class="produto-titulo">
        <p id="produto-titulo"><img src="../img/Brinquedos.png" style="width: 20px; height: 20px;"/> BRINQUEDOS</p>
        <p id="produto-descricao">Mordedores, bolinhas e cabos de guerra.</p>
    </div>
    </div>
    <div class="centro">
            <?php
                    require_once "../util/config.php";

                    $sql = "SELECT * FROM produtos";
                    $result = mysqli_query($link, $sql);
                    $contador = 0;
                    while($contador <= 5){
                        while($row = mysqli_fetch_array($result)){
                            if($row['tipo'] == "Brinquedo"){
            ?>
        <div class="produto">
            <div class="box">   
                <div class="img-produto">
                    <img src= "<?php echo $row['imagem']; ?>" />
                </div>
                <div class="texto">
                    <p id="produto-nome"><?php echo $row['nome']; ?></p>
                    <p><?php echo $row['descricao']; ?></p> 
                    <p><?php echo $row['preco']; ?></p>
                </div>
            </div>
        </div>
        <?php
                            }$contador += 1;
                        }
                    }
        ?>
    </div>

<div class="rodape-cor">
    <div class="rodape-posicao">
        <div class="rodape-dados">
            <div class="rodape-logo">
                <ul>
                    <li><img src="../img/logo_upet.png" /></li>
                    <li>Upet 2022. Todos os Direitos reservados</li>
                    <li>Desenvolvido por MELD</li>
                </ul>
            </div>
        </div>
    </div>
</div>

</body>
</html>