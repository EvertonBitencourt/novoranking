$('#confirmacaoExlusaoModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var idTime = button.data('codigo') // Extract info from data-* attributes
  var descricaoTime = button.data('nome');
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  //var modal = $(this)
  //modal.find('.modal-title').text('New message to ' + recipient)
  //modal.find('.modal-body input').val(recipient)
  
  var modal = $(this);
  var form = modal.find('form');
  var action = form.data('url-base');
  if(!action.endsWith('/')){
	  action += '/';
  }
  form.attr('action', action + idTime);
  modal.find('.modal-body span').html('Tem certeza que deseja excluir o time <strong>' + descricaoTime + '</strong>?');
}) ;