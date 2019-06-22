<template id="menu">
    <nav class="col-sm-3 sidenav" style="padding-right: 1%">
        <div style="margin-left: 3%"><h2>Menu</h2></div> 
        <hr>
            <ul class="nav nav-pills nav-stacked" style="margin-left: 3%; margin-top: 9%">
                <li class="active"><a href="#" id="linkcolor" v-on:click="escondePacientes()">Página Inicial</a>
                </li>
                <li class="active"><a href="paciente-inserir.html" id="linkcolor" v-on:click="mostrarPacientes()">Cadastrar Paciente</a></li>
                <li class="active"><a href="cadastrar-consulta.html" id="linkcolor" v-on:click="mostrarPacientes()">Cadastrar Consulta</a></li>
                <li class="active"><a href="user-editar.html" id="linkcolor"><img src="Images/gears.png" style="width:30px; height: 30px"></img>Alterar meus dados</a></li>
            </ul>
    </nav>
</template>

<script>
module.exports = {
name: "menusidebar",
};
</script>