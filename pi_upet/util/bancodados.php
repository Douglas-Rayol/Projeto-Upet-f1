<?php
    class BancoDados{
        public $servidor = "localhost";
        public $usuario = "root";
        public $senha = "";
        public $banco = "pi_upet";
        public $con;

        public function conectar(){
            $this->con = mysqli_connect($this->servidor, $this->usuario, $this->senha, $this->banco);
            if($this->con === false){
                return false;
            } else{
                return true;
            }
        }
    }
?>