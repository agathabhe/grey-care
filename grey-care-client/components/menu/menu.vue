<template id="menu">
    <nav class="col-sm-3  sidenav" style="padding-right: 1%">
        <h2 style="color: white; margin-left: 3.5%"> Menu</h2>
            <hr>
            <ul class="nav nav-pills nav-stacked" style="margin-left: 3%">
                <li class="active"><a href="#" id="linkcolor" v-on:click="escondePacientes()">Página Inicial</a>
                </li>
                <li class="active"><a href="paciente-inserir.html" id="linkcolor" v-on:click="mostrarPacientes()">Pacientes</a></li>
                <li class="active"><a class="disabled" id="linkcolor"><img src="Images/gears.png" style="width:30px; height: 30px"></img>Alterar meus dados</a></li>
                <!-- <li class="acitve"><a href="paciente-inserir.html" id="linkcolor">Inserir pacientes</a></li> -->
            </ul>
    </nav>
</template>

<script>
module.exports = {
name: "menusidebar",
};
</script>