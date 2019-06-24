<template id="menu">
    <nav class="col-sm-3 sidenav" style="padding-right: 1%">
        <h2 style="color: white; margin-left: 3.5%"> Menu</h2>
        <hr>
            <ul class="nav nav-pills nav-stacked" style="margin-left: 3%; margin-top: 9%">
                <li class="active"><a href="#" id="linkcolor" v-on:click="escondePacientes()">Página Inicial</a></li>
                <li class="active"><a href="#" id="linkcolor" v-on:click="mostrarPacientes()">Ver Pacientes</a></li>
                <li class="active"><a href="paciente-inserir.html" id="linkcolor">Cadastrar Paciente</a></li>
                <li class="active"><a href="alterar-dados.html" id="linkcolor"><img src="Images/gears.png" style="width:30px; height: 30px"></img>Alterar meus dados</a></li>
                
            </ul>
    </nav>
</template>

<script>
module.exports = {
name: "menusidebar",
};
</script>