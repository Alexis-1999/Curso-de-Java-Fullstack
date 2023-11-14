// Call the dataTables jQuery plugin
$(document).ready(function() {


});


async function iniciarSesion() {
  let datos = {
      email: document.getElementById('txtEmail').value,
      password: document.getElementById('txtPassword').value
  };

  try {
      const request = await fetch('/api/login', {
          method: 'POST',
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(datos)
      });

      const respuesta = await request.json();

      if(respuesta == 'OK'){
        window.location.href = 'usuario.html';
      } else{
        alert("Las credenciales son incorrectas. Por famor intente nuevamente");
      }

      if (!request.ok) {
          throw new Error(`Error en la solicitud: ${request.status} ${request.statusText}`);
      }

      const responseText = await request.text();
      console.log('Respuesta del servidor:', responseText);
  } catch (error) {
      console.error('Error al procesar la respuesta JSON:', error);
  }
}
