import React, { useState } from 'react';
import './index.css';
import { FaLock } from 'react-icons/fa';
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import { Card, CardContent, Typography, Button, TextField, Container } from '@mui/material';

function RedefinirSenha() {
  const [senhaAtual, setSenhaAtual] = useState("");
  const [novaSenha, setNovaSenha] = useState("");
  const navigate = useNavigate(); 

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/redefinir-senha", {
        senhaAtual,
        novaSenha,
      });
      if (response.status === 200) {
        alert("Senha redefinida com sucesso!");
        navigate('/Login');
      } else {
        alert("Erro ao redefinir senha: " + response.data);
      }
    } catch (error) {
      alert("Erro ao redefinir senha: Verifique sua senha atual.");
      console.error("Erro ao redefinir a senha:", error);
    }
  };  

  return (
    <Container className='container-base'>
      <div className="redefinir-senha-container">
        <Card className="card-container" style={{ maxWidth: 400, margin: '0 auto', padding: '20px 30px' }}>
          <CardContent>
            <div className="login-logo" style={{ textAlign: 'center' }}>
            <img src="/images/images-removebg-preview.png" alt="Logo" style={{ width: '80px', marginBottom: '20px' }} />
            </div>
            <Typography variant="h5" align="center" gutterBottom>
              <FaLock style={{ marginRight: '10px' }} />
              Redefinir Senha
            </Typography>
            <form onSubmit={handleSubmit}>
              <TextField
                label="Senha Atual"
                type="password"
                variant="outlined"
                fullWidth
                margin="normal"
                value={senhaAtual}
                onChange={(e) => setSenhaAtual(e.target.value)}
              />
              <TextField
                label="Nova Senha"
                type="password"
                variant="outlined"
                fullWidth
                margin="normal"
                value={novaSenha}
                onChange={(e) => setNovaSenha(e.target.value)}
              />
              <Button
                type="submit"
                variant="contained"
                color="primary"
                fullWidth
                style={{ marginTop: '20px', backgroundColor: '#3498db' }}
              >
                Alterar Senha
              </Button>
            </form>
          </CardContent>
        </Card>
      </div>
    </Container>
  );
}

export default RedefinirSenha;