// Call the dataTables jQuery plugin
$(document).ready(function() {


  });
  
  
async function registrarUsuario() {
    let datos = {
        nombre: document.getElementById('txtNombre').value,
        apellido: document.getElementById('txtApellido').value,
        email: document.getElementById('txtEmail').value,
        password: document.getElementById('txtPassword').value
    };

    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if(repetirPassword !== datos.password){
        alert('La contraseña que escribiste es diferente');
        return;
    }

    try {
        const request = await fetch('/api/usuarios/', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        if (!request.ok) {
            throw new Error(`Error en la solicitud: ${request.status} ${request.statusText}`);
        }

        const responseText = await request.text();
        console.log('Respuesta del servidor:', responseText);
    } catch (error) {
        console.error('Error al procesar la respuesta JSON:', error);
    }
}

