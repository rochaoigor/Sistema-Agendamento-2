import React from 'react';
import { Dialog, DialogTitle, DialogContent, DialogContentText, DialogActions, Button } from '@mui/material';

function ErroDialog({ mensagem, aberto, fechar }) {
  return (
    <Dialog open={aberto} onClose={fechar}>
      <DialogTitle>Erro ao Agendar</DialogTitle>
      <DialogContent>
        <DialogContentText>
          {mensagem}
        </DialogContentText>
      </DialogContent>
      <DialogActions>
        <Button onClick={fechar} autoFocus>
          Fechar
        </Button>
      </DialogActions>
    </Dialog>
  );
}

export default ErroDialog;