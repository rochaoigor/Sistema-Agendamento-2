import React from 'react';
import { Container, Typography, Button, Box } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import './index.css';

const Logout = () => {

  const navigate = useNavigate();

  const handleSim = () => {
    navigate('/Login'); 
  };

  const handleNao = () => {
    navigate('/Menu'); 
  };

  return (
    <Container maxWidth="sm" className="logout-page-container">
      <Box className="logout-header" display="flex" justifyContent="center" mb={3}>
        <img className="logo-logout" src="/images/images-removebg-preview.png" alt="Logo" />
      </Box>

      <Typography variant="h4" component="h2" align="center" gutterBottom>
        LOGOUT
      </Typography>

      <Typography variant="body1" align="center">
        Deseja realmente encerrar sua sessão?
      </Typography>

      <Box display="flex" justifyContent="center" mt={3} gap={2}>
        <Button variant="contained" color="primary" className="btn-sim" onClick={handleSim}>
          Sim
        </Button>
        <Button variant="contained" color="error" className="btn-nao" onClick={handleNao}>
          Não
        </Button>
      </Box>
    </Container>
  );
};

export default Logout;