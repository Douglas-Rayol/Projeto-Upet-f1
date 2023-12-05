<?php
    require_once "./util/config.php";
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel="stylesheet" type="text/css" href="./css/vitrine.css"></linl>
    <meta charset="UTF-8">
    <title>Upet Pet Store</title>
    <link rel="shortcut icon" href="../upet.ico">
</head>
<body>
    <header class="menu-principal">
        <main>
            <div class="header-1">
                <div class="logo">
                    <a href="index.php"><img src="./img/logo_upet.png"/></a>
                </div>
                <div class="menu-secao">
                    <ul>
                        <li><a href="./produto/create.php">Cadastrar produto</a></li>
                    </ul>
                </div>
                <div class="menu-opcao">
                <?php
                    $sql = "SELECT * FROM cliente";
                    $result = mysqli_query($link, $sql);
                    while($row = mysqli_fetch_array($result)){
                        if($row['idcliente'] == 2){
                ?>
                    <a href="#">Olá, <?php echo $row['nome'] ?></a>
                </div>
                <?php
                        }
                    }
                ?>
            </div>
            <!-- Carrossel de Slides -->
            <div class="slider">
                <div class="slides">
                    <!-- Radio Buttons -->
                    <input type="radio" name="radio-btn" id="radio1">
                    <input type="radio" name="radio-btn" id="radio2">
                    <input type="radio" name="radio-btn" id="radio3">
                    <input type="radio" name="radio-btn" id="radio4">
        
                    <!-- Slide images -->
                    <div class="slide first">
                        <img src="./img/Imagem1.png" alt="Imagem 1" />
                    </div>
                    <div class="slide">
                        <img src="./img/Imagem2.png" alt="Imagem 2" />
                    </div>
                    <div class="slide">
                        <img src="./img/Imagem3.png" alt="Imagem 3" />
                    </div>
                    <div class="slide">
                        <img src="./img/Imagem4.png" alt="Imagem 4" />
                    </div>
        
                    <!--Navigation auto-->
                    <div class="navigation-auto">
                        <div class="auto-btn1"></div>
                        <div class="auto-btn2"></div>
                        <div class="auto-btn3"></div>
                        <div class="auto-btn4"></div>
                    </div>
                </div>
        
                <div class="manual-navigation">
                    <label for="radio1" class="manual-btn"></label>
                    <label for="radio2" class="manual-btn"></label>
                    <label for="radio3" class="manual-btn"></label>
                    <label for="radio4" class="manual-btn"></label>     
                </div>
            </div>
            <!-- Fim do Carrossel de Slides -->
        </main>
    </header>

     <!-- ALIMENTOS -->
<div class="centro">
        <div class="produto-titulo">
            <p id="produto-titulo"><img src="./img/Alimentos.png" style="width: 20px; height: 20px;"/> ALIMENTOS</p>
            <p id="produto-descricao">As melhores rações, petiscos e ossos você encontra aqui.</p>
        </div>
        <?php
                require_once "./util/config.php";

                $sql = "SELECT * FROM produtos";
                $result = mysqli_query($link, $sql);
                $contador = 0;
                while($contador <= 5){
                    while($row = mysqli_fetch_array($result)){
                        if($row['tipo'] == "Alimento"){
        ?>
    <div class="produto">
        <div class="box">   
            <div class="img-produto">
                <img src= "<?php echo $row['img']; ?>" />
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

    <!-- ACESSÓRIOS -->
<div class="centro">
            <div class="produto-titulo">
                <p id="produto-titulo"><img src="./img/Acessórios.png" style="width: 20px; height: 20px;"/> ACESSÓRIOS</p>
                <p id="produto-descricao">Vestuário, coleiras e tudo que você precisa pro seu pet.</p>
            </div>

        <?php
                require_once "./util/config.php";

                $sql = "SELECT * FROM produtos";
                $result = mysqli_query($link, $sql);
                $contador = 0;
                while($contador <= 5){
                    while($row = mysqli_fetch_array($result)){
                        if($row['tipo'] == "Acessorio"){
        ?>
    <div class="produto">
        <div class="box">   
            <div class="img-produto">
                <img src= "<?php echo $row['img']; ?>" />
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

    <!-- BRINQUEDOS -->
<div class="centro">
            <div class="produto-titulo">
                <p id="produto-titulo"><img src="./img/Brinquedos.png" style="width: 20px; height: 20px;"/> BRINQUEDOS</p>
                <p id="produto-descricao">Mordedores, bolinhas e cabos de guerra.</p>
            </div>

        <?php
                require_once "./util/config.php";

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
                <img src= "<?php echo $row['img']; ?>" />
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

    <!-- SAÚDE E HIGIENE -->
<div class="centro">
            <div class="produto-titulo">
                <p id="produto-titulo"><img src="./img/Higiene.png" style="width: 20px; height: 20px;"/> SAÚDE E HIGIENE</p>
                <p id="produto-descricao">Medicamentos e artigos de higiene.</p>
            </div>

        <?php
                require_once "./util/config.php";

                $sql = "SELECT * FROM produtos";
                $result = mysqli_query($link, $sql);
                $contador = 0;
                while($contador <= 5){
                    while($row = mysqli_fetch_array($result)){
                        if($row['tipo'] == "Higiene"){
        ?>
    <div class="produto">
        <div class="box">   
            <div class="img-produto">
                <img src= "<?php echo $row['img']; ?>" />
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
                    <li><img src="./img/logo_upet.png" /></li>
                    <li>Upet 2022. Todos os Direitos reservados</li>
                    <li>Desenvolvido por MELD</li>
                </ul>
            </div>
        </div>
    </div>
</div>


<script>

    //Carrossel de Slides
    let count = 1;

    document.getElementById("radio1").checked = true;

    setInterval(function(){
        nextImage();
    }, 5000)

    function nextImage(){
        count++;
        if(count>4){
            count=1;
        }

        document.getElementById("radio"+count).checked = true;
    }
    //Fim do Carrossel de Slides    
</script>
</body>
</html>