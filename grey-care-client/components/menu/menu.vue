<template id="menu">
  <nav class="col-sm-3 sidenav" style="padding-right: 1%">
    <h2 style="color: white; margin-left: 3.5%">Menu</h2>
    <hr>
    <ul class="nav nav-pills nav-stacked" style="margin-left: 3%; margin-top: 9%">
      <li class="active">
        <a href="#" id="linkcolor" v-on:click="mostrarPaginaInicial(page)">Página Inicial</a>
      </li>
      <li class="active">
        <a href="#" id="linkcolor" v-on:click="mostrarPacientes(page)">Ver Pacientes</a>
      </li>
      <li class="active">
        <a href="paciente-inserir.html" id="linkcolor">Cadastrar Paciente</a>
      </li>
      <li class="active">
        <a href="#" id="linkcolor" v-on:click="mostrarUsuario(page)">
          <img src="Images/gears.png" style="width:30px; height: 30px">Alterar meus dados
        </a>
      </li>
    </ul>
  </nav>
</template>

<script>
module.exports = {
  name: "menusidebar",
  props: ["page"],
  methods: {
    mostrarPacientes: function(page) {
      page.mostraTabela = true;
    },
    mostrarPaginaInicial: function(page) {
      page.mostraTabela = false;
    },
    mostrarUsuario: function(page) {
    //   page.usuario = usuario;
      //Recebe o Modal
      var modal = document.getElementById("usuarioModal");

      //Recebe a tag span que fecha o Modal
      var span = document.getElementsByClassName("close")[0];

      modal.style.display = "block";

      //Fecha o Modal ao clicar no x
      span.onclick = function() {
        modal.style.display = "none";
      };

      //Quando clicar em qualquer lugar fora do Modal ele é fechado
      window.onclick = function(event) {
        if (event.target == modal) {
          modal.style.display = "none";
        }
      };
    }
  }
};
</script>