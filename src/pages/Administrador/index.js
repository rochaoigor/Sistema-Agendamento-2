import React, { useState } from 'react';
import { 
    Container, TextField, Button, Box, Typography, AppBar, Toolbar, IconButton, 
    Dialog, DialogTitle, DialogContent, DialogActions, Select, MenuItem, FormControl, InputLabel 
} from '@mui/material';
import LogoutIcon from '@mui/icons-material/Logout';
import { useNavigate } from 'react-router-dom';

function Administrador() {

  const navigate = useNavigate();

    const [modulos, setModulos] = useState([]); 
    const [alunos, setAlunos] = useState([]);
    const [openAlunoModal, setOpenAlunoModal] = useState(false);
    const [openRelatorioModal, setOpenRelatorioModal] = useState(false);

    const [novoAluno, setNovoAluno] = useState({
        ra: '', nome: '', curso: '', disciplinas: '', email: '', contato: ''
    });

    const handleAdicionarModulo = () => {
        setModulos([...modulos, { 
            nome: '', 
            periodoInicio: '', 
            periodoFim: '', 
            horarios: [], 
            diasSemana: [], 
            curso: '', 
            disciplina: '' 
        }]);
    };

    const handleRemoverModulo = (index) => {
        const novosModulos = [...modulos];
        novosModulos.splice(index, 1);
        setModulos(novosModulos);
    };

    const handleMudancaModulo = (index, campo, valor) => {
        const novosModulos = [...modulos];
        novosModulos[index][campo] = valor;
        setModulos(novosModulos);
    };

    const handleAdicionarHorario = (index) => {
        const novosModulos = [...modulos];
        novosModulos[index].horarios.push('');
        setModulos(novosModulos);
    };

    const handleRemoverHorario = (indexModulo, indexHorario) => {
        const novosModulos = [...modulos];
        novosModulos[indexModulo].horarios.splice(indexHorario, 1);
        setModulos(novosModulos);
    };

    const handleMudancaHorario = (indexModulo, indexHorario, valor) => {
        const novosModulos = [...modulos];
        novosModulos[indexModulo].horarios[indexHorario] = valor;
        setModulos(novosModulos);
    };

    const handleMudancaDiasSemana = (index, valor) => {
        const novosModulos = [...modulos];
        novosModulos[index].diasSemana = valor;
        setModulos(novosModulos);
    };

    const handleAdicionarAluno = () => {
        setOpenAlunoModal(true);
    };

    const handleFecharAlunoModal = () => {
        setOpenAlunoModal(false);
        setNovoAluno({ ra: '', nome: '', curso: '', disciplinas: '', email: '', contato: '' });
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNovoAluno(prevState => ({ ...prevState, [name]: value }));
    };

    const handleSalvarAluno = () => {
        setAlunos([...alunos, novoAluno]);
        handleFecharAlunoModal();
    };

    const handleSubmit = () => {
        setOpenRelatorioModal(true);
    };

    const handleLogout = () => {
      navigate('/login');
    };

    const handleFecharRelatorioModal = () => {
        setOpenRelatorioModal(false);
    };

    return (
        <Container>
            <AppBar position="static" color="transparent" elevation={0}>
                <Toolbar>
                    <Box sx={{ flexGrow: 1, textAlign: 'center' }}>
                        <img src="/images/images-removebg-preview.png" alt="Logo do Sistema de Agendamento" style={{ height: 80 }} />
                    </Box>
                    <Button className="logout-button" sx={{ position: 'absolute', top: '20px', right: '20px'
  }} onClick={handleLogout}>
        <LogoutIcon /> Sair
      </Button>
                </Toolbar>
            </AppBar>

            <Typography variant="h4" gutterBottom align="center" mt={3}>
                Painel do Administrador
            </Typography>

            <Box display="flex" justifyContent="space-between" mt={3}>
                <Button variant="contained" onClick={handleAdicionarModulo} sx={{ flexGrow: 0 }}>
                    Adicionar Módulo
                </Button>
                <Button variant="contained" onClick={handleAdicionarAluno}> 
                    Adicionar Aluno
                </Button>
            </Box>

            {modulos.map((modulo, index) => (
                <Box key={index} mt={3} p={2} border={1} borderColor="grey.300">
                    <Typography variant="h6">Módulo {index + 1}</Typography>
                    
                    <TextField 
                        label="Nome do Módulo" 
                        fullWidth 
                        margin="dense" 
                        value={modulo.nome} 
                        onChange={(e) => handleMudancaModulo(index, 'nome', e.target.value)} 
                    />
                    <TextField 
                        label="Curso" 
                        fullWidth 
                        margin="dense" 
                        value={modulo.curso} 
                        onChange={(e) => handleMudancaModulo(index, 'curso', e.target.value)} 
                    />
                    <TextField 
                        label="Disciplina" 
                        fullWidth 
                        margin="dense" 
                        value={modulo.disciplina} 
                        onChange={(e) => handleMudancaModulo(index, 'disciplina', e.target.value)} 
                    />
                    <TextField 
                        label="Período Início" 
                        fullWidth 
                        margin="dense" 
                        type="date"
                        InputLabelProps={{ shrink: true }}
                        value={modulo.periodoInicio} 
                        onChange={(e) => handleMudancaModulo(index, 'periodoInicio', e.target.value)} 
                    />
                    <TextField 
                        label="Período Fim" 
                        fullWidth 
                        margin="dense" 
                        type="date"
                        InputLabelProps={{ shrink: true }}
                        value={modulo.periodoFim} 
                        onChange={(e) => handleMudancaModulo(index, 'periodoFim', e.target.value)} 
                    />

                    <FormControl fullWidth sx={{ mt: 2 }}>
                        <InputLabel>Dias da Semana</InputLabel>
                        <Select
                            multiple
                            value={modulo.diasSemana}
                            onChange={(e) => handleMudancaDiasSemana(index, e.target.value)}
                            renderValue={(selected) => selected.join(', ')}
                        >
                            {['Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo'].map((dia) => (
                                <MenuItem key={dia} value={dia}>
                                    {dia}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>

                    <Typography variant="subtitle1" mt={2}>Horários</Typography>
                    {modulo.horarios.map((horario, i) => (
                        <Box display="flex" alignItems="center" key={i}>
                            <TextField 
                                label={`Horário ${i + 1}`} 
                                fullWidth 
                                margin="dense" 
                                value={horario} 
                                onChange={(e) => handleMudancaHorario(index, i, e.target.value)} 
                            />
                            <Button 
                                variant="outlined" 
                                color="error" 
                                onClick={() => handleRemoverHorario(index, i)} 
                                sx={{ ml: 2 }}
                            >
                                Remover Horário
                            </Button>
                        </Box>
                    ))}
                    <Button variant="outlined" onClick={() => handleAdicionarHorario(index)} sx={{ mt: 2 }}>
                        Adicionar Horário
                    </Button>
                    <Button variant="outlined" color="error" onClick={() => handleRemoverModulo(index)} sx={{ mt: 2, ml: 2 }}>
                        Remover Módulo
                    </Button>
                </Box>
            ))}

            <Dialog open={openAlunoModal} onClose={handleFecharAlunoModal}>
                <DialogTitle>Adicionar Aluno</DialogTitle>
                <DialogContent>
                    <TextField label="RA" fullWidth margin="dense" name="ra" value={novoAluno.ra} onChange={handleInputChange} />
                    <TextField label="Nome" fullWidth margin="dense" name="nome" value={novoAluno.nome} onChange={handleInputChange} />
                    <TextField label="Curso" fullWidth margin="dense" name="curso" value={novoAluno.curso} onChange={handleInputChange} />
                    <TextField label="Disciplina" fullWidth margin="dense" name="disciplinas" value={novoAluno.disciplinas} onChange={handleInputChange} />
                    <TextField label="E-mail" fullWidth margin="dense" name="email" value={novoAluno.email} onChange={handleInputChange} />
                    <TextField label="Contato" fullWidth margin="dense" name="contato" value={novoAluno.contato} onChange={handleInputChange} />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleFecharAlunoModal}>Cancelar</Button>
                    <Button onClick={handleSalvarAluno}>Salvar</Button>
                </DialogActions>
            </Dialog>

            <Box display="flex" justifyContent="center" sx={{ mt: 3 }}>
                <Button variant="contained" color="secondary" onClick={handleSubmit} sx={{ backgroundColor: 'dodgerblue', border: '2px solid', borderColor: 'green'}}>
                    Salvar Dados
                </Button>
            </Box>

            <Dialog open={openRelatorioModal} onClose={handleFecharRelatorioModal} fullWidth maxWidth="md">
                <DialogTitle>Relatório de Dados Preenchidos</DialogTitle>
                <DialogContent dividers>
                    <Typography variant="h6">Módulos</Typography>
                    {modulos.map((modulo, index) => (
                        <Box key={index} mb={2}>
                            <Typography><strong>Módulo {index + 1}:</strong></Typography>
                            <Typography>Nome: {modulo.nome}</Typography>
                            <Typography>Curso: {modulo.curso}</Typography>
                            <Typography>Disciplina: {modulo.disciplina}</Typography>
                            <Typography>Período Início: {modulo.periodoInicio}</Typography>
                            <Typography>Período Fim: {modulo.periodoFim}</Typography>
                            <Typography>Dias da Semana: {modulo.diasSemana.join(', ')}</Typography>
                            <Typography>Horários: {modulo.horarios.join(', ')}</Typography>
                        </Box>
                    ))}
                    <Typography variant="h6">Alunos</Typography>
                    {alunos.map((aluno, index) => (
                        <Box key={index} mb={2}>
                            <Typography><strong>Aluno {index + 1}:</strong></Typography>
                            <Typography>RA: {aluno.ra}</Typography>
                            <Typography>Nome: {aluno.nome}</Typography>
                            <Typography>Curso: {aluno.curso}</Typography>
                            <Typography>Disciplina: {aluno.disciplinas}</Typography>
                            <Typography>E-mail: {aluno.email}</Typography>
                            <Typography>Contato: {aluno.contato}</Typography>
                        </Box>
                    ))}
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleFecharRelatorioModal} color="primary">Fechar</Button>
                </DialogActions>
            </Dialog>
        </Container>
    );
}

export default Administrador;