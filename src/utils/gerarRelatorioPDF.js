import jsPDF from 'jspdf';
import 'jspdf-autotable';

async function gerarRelatorioPDF() {
  const doc = new jsPDF();

  // 1. Buscar os dados do relatório no banco de dados
  const dadosRelatorio = await buscarDadosRelatorio();

  // 2. Configurar o layout do relatório (margens, fonte, etc.)
  const marginLeft = 20;
  const marginTop = 20;
  doc.setProperties({ top: marginTop, right: 20, bottom: 20, left: marginLeft });
  doc.setFont('helvetica', 'normal', 12);

  // 3. Adicionar a logo no topo
  const logoImg = new Image();
  logoImg.src = '/images/images-removebg-preview.png'; 
  await logoImg.decode(); 
  doc.addImage(logoImg, 'PNG', marginLeft, marginTop, 50, 50); // Ajustar coordenadas x e y

  // 4. Adicionar o nome do polo abaixo da logo
  doc.text('Polo EAD UNIFAA - Valença', marginLeft, marginTop + 60); // Ajustar coordenada y

  // 5. Adicionar a tabela abaixo do nome do polo
  doc.autoTable({
    startY: marginTop + 70, // Ajustar coordenada y 
    head: [['Aluno', 'Prova', 'Data']],
    body: dadosRelatorio.map((item) => [item.aluno, item.prova, item.data]),
  });

  // 6. Salvar o PDF
  doc.save("Relatorio.pdf");
}

async function buscarDadosRelatorio() {
  return [
    { aluno: 'Weberson Serafim', prova: 'Disciplina 1 - A2', data: '10/11/2024' },
    { aluno: 'Jorge Dias', prova: 'Disciplina 1 - A3', data: '15/11/2024' },
    { aluno: 'Rafael Rodrigues', prova: 'Disciplina 2 - A2', data: '20/11/2024' },
    { aluno: 'Matheus Santos', prova: 'Disciplina 2 - A3', data: '25/11/2024' },
  ];
}

export default gerarRelatorioPDF;