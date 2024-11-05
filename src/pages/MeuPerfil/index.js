import React, { useState, useEffect } from 'react';
import './index.css';
import { FaUserCircle } from 'react-icons/fa';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { 
  Container, 
  Typography, 
  TextField, 
  Button, 
  Avatar, 
  Box 
} from '@mui/material';

const MeuPerfil = () => {
  const [perfil, setPerfil] = useState({});

  useEffect(() => {
    axios.get('http://localhost:8080/api/perfil')
      .then(response => {
        setPerfil(response.data);
      })
      .catch(error => {
        console.error('Erro ao buscar os dados do perfil:', error);
      });
  }, []);

  const navigate = useNavigate();
  const handleReturn = () => {
    navigate('/Menu'); 
  };

  return (
    <Container maxWidth="sm" className="perfil-container"> 
      <Box className="perfil-header" display="flex" flexDirection="column" alignItems="center">
        <img src="/images/images-removebg-preview.png" alt="Logo" className="perfil-logo" />
        <Typography variant="h4" component="h1">
          Meu Perfil
        </Typography>
      </Box>

      <Box className="perfil-form" mt={3}>
        <Avatar className="perfil-icon">
          <FaUserCircle /> 
        </Avatar>
        <TextField 
          label="Nome Completo" 
          variant="outlined" 
          fullWidth 
          margin="normal"
          value={perfil.nome || 'Carregando...'} 
          InputProps={{
            readOnly: true,
          }}
        />
        <TextField 
          label="E-mail" 
          variant="outlined" 
          fullWidth 
          margin="normal"
          value={perfil.email || 'Carregando...'} 
          InputProps={{
            readOnly: true,
          }}
        />
        <TextField 
          label="Telefone" 
          variant="outlined" 
          fullWidth 
          margin="normal"
          value={perfil.telefone || 'Carregando...'} 
          InputProps={{
            readOnly: true,
          }}
        />
        <TextField 
          label="RA" 
          variant="outlined" 
          fullWidth 
          margin="normal"
          value={perfil.ra || 'Carregando...'} 
          InputProps={{
            readOnly: true,
          }}
        />
        <TextField 
          label="Curso" 
          variant="outlined" 
          fullWidth 
          margin="normal"
          value={perfil.curso || 'Carregando...'} 
          InputProps={{
            readOnly: true,
          }}
        />
        <TextField 
          label="Período do Curso" 
          variant="outlined" 
          fullWidth 
          margin="normal"
          value={perfil.periodo || 'Carregando...'} 
          InputProps={{
            readOnly: true,
          }}
        />
        <TextField 
          label="Cidade" 
          variant="outlined" 
          fullWidth 
          margin="normal"
          value={perfil.cidade || 'Carregando...'} 
          InputProps={{
            readOnly: true,
          }}
        />
        <TextField 
          label="Polo" 
          variant="outlined" 
          fullWidth 
          margin="normal"
          value={perfil.polo || 'Carregando...'} 
          InputProps={{
            readOnly: true,
          }}
        />
        <Button 
          variant="contained" 
          color="primary" 
          className="voltar-btn"
          fullWidth
          onClick={handleReturn}
        >
          Voltar
        </Button>
      </Box>
    </Container>
  );
};

export default MeuPerfil;