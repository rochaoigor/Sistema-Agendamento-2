import React from 'react'; 
import { AiOutlineMail, AiOutlineWhatsApp, AiOutlineMenu, AiOutlineLogout } from 'react-icons/ai';
import { Container, Typography, Button, Box, IconButton, Card, CardContent } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import './index.css';


const Suporte = () => {

  const navigate = useNavigate();

  const handleFaleConosco = () => {
    window.location.href = "https://unifaa.edu.br/contato"; 
  };

  const handleWhatsapp = () => {
    window.location.href = "https://api.whatsapp.com/send?phone=552424530770"; 
  };

  const handleVoltar = () => {
    navigate('/Menu'); 
  };

const handleLogout = () => {
    navigate('/Logout'); 
  };

  return (
    <Container maxWidth="sm" className="container-base">
      <Box className="suporte-header" display="flex" justifyContent="space-between" alignItems="center">
        <IconButton className="menu-icon-suporte" onClick={handleVoltar}>
          <AiOutlineMenu size={28} />
        </IconButton>
        <img className="logo-suporte" src="/images/images-removebg-preview.png" alt="Logo" />
        <IconButton className="logout-icon" onClick={handleLogout}>
          <AiOutlineLogout size={28} />
        </IconButton>
      </Box>

      <Typography variant="h4" gutterBottom>
        Suporte
      </Typography>
      <Typography variant="body1" align="center">
        Precisa de Ajuda? Escolha um canal e envie sua mensagem!
      </Typography>

      <Box mt={4} className="support-options">
        <Card className="support-option">
          <CardContent>
            <Box display="flex" alignItems="center">
              <AiOutlineMail size={70} />
              <Box ml={2}>
                <Typography variant="h6">Fale Conosco</Typography>
                <Button variant="contained" color="primary" onClick={handleFaleConosco}>
                  Enviar Mensagem
                </Button>
              </Box>
            </Box>
          </CardContent>
        </Card>

        <Card className="support-option">
          <CardContent>
            <Box display="flex" alignItems="center">
              <AiOutlineWhatsApp size={70} />
              <Box ml={2}>
                <Typography variant="h6">Whatsapp (08:00 às 17:00)</Typography>
                <Button variant="contained" color="primary" onClick={handleWhatsapp}>
                  Enviar Mensagem
                </Button>
              </Box>
            </Box>
          </CardContent>
        </Card>
      </Box>
    </Container>
  );
};

export default Suporte;