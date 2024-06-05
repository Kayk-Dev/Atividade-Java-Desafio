import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtividadeProaJava extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public AtividadeProaJava() {
        setTitle("Exercícios de Java");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        inputField = new JTextField();
        JButton submitButton = new JButton("Enviar");

        inputPanel.add(inputField);
        inputPanel.add(submitButton);
        add(inputPanel, BorderLayout.NORTH);

        // Área de saída
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new GridLayout(3, 5));
        String[] buttons = {
                "Par ou Ímpar", "Positivo/Negativo/Zero", "Maior de Dois", "Triângulo Válido",
                "Média do Aluno", "Ano Bissexto", "Faixa Etária", "Conceito de Nota",
                "Categoria de Produto", "Operação Matemática", "Intervalo de 10 a 20",
                "Maior que 100", "Desconto por Categoria", "Raiz/Quadrado", "IMC"
        };
        for (String text : buttons) {
            JButton button = new JButton(text);
            buttonPanel.add(button);
            button.addActionListener(new ButtonClickListener());
        }
        add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(new SubmitButtonListener());
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            outputArea.append(input + "\n");
            inputField.setText("");
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            outputArea.append("Você selecionou: " + actionCommand + "\n");
            switch (actionCommand) {
                case "Par ou Ímpar":
                    parOuImpar();
                    break;
                case "Positivo/Negativo/Zero":
                    positivoNegativoZero();
                    break;
                case "Maior de Dois":
                    maiorDeDois();
                    break;
                case "Triângulo Válido":
                    trianguloValido();
                    break;
                case "Média do Aluno":
                    mediaDoAluno();
                    break;
                case "Ano Bissexto":
                    anoBissexto();
                    break;
                case "Faixa Etária":
                    faixaEtaria();
                    break;
                case "Conceito de Nota":
                    conceitoNota();
                    break;
                case "Categoria de Produto":
                    categoriaProduto();
                    break;
                case "Operação Matemática":
                    operacaoMatematica();
                    break;
                case "Intervalo de 10 a 20":
                    intervalo10a20();
                    break;
                case "Maior que 100":
                    maiorQue100();
                    break;
                case "Desconto por Categoria":
                    descontoCategoria();
                    break;
                case "Raiz/Quadrado":
                    raizQuadrado();
                    break;
                case "IMC":
                    calcularIMC();
                    break;
                default:
                    break;
            }
        }
    }

    // Métodos para cada exercício
    private void parOuImpar() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));
        if (numero % 2 == 0) {
            outputArea.append("O número " + numero + " é par.\n");
        } else {
            outputArea.append("O número " + numero + " é ímpar.\n");
        }
    }

    private void positivoNegativoZero() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));
        if (numero > 0) {
            outputArea.append("O número " + numero + " é positivo.\n");
        } else if (numero < 0) {
            outputArea.append("O número " + numero + " é negativo.\n");
        } else {
            outputArea.append("O número é zero.\n");
        }
    }

    private void maiorDeDois() {
        int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
        int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número:"));
        if (numero1 > numero2) {
            outputArea.append("O primeiro número " + numero1 + " é maior.\n");
        } else if (numero2 > numero1) {
            outputArea.append("O segundo número " + numero2 + " é maior.\n");
        } else {
            outputArea.append("Os números são iguais.\n");
        }
    }

    private void trianguloValido() {
        int lado1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro lado:"));
        int lado2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo lado:"));
        int lado3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o terceiro lado:"));
        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
            outputArea.append("Os lados formam um triângulo válido.\n");
        } else {
            outputArea.append("Os lados não formam um triângulo válido.\n");
        }
    }

    private void mediaDoAluno() {
        double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota:"));
        double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota:"));
        double nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a terceira nota:"));
        double media = (nota1 + nota2 + nota3) / 3;
        if (media >= 7) {
            outputArea.append("Aluno aprovado com média: " + media + "\n");
        } else if (media >= 5) {
            outputArea.append("Aluno em recuperação com média: " + media + "\n");
        } else {
            outputArea.append("Aluno reprovado com média: " + media + "\n");
        }
    }

    private void anoBissexto() {
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite um ano:"));
        if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
            outputArea.append("O ano " + ano + " é bissexto.\n");
        } else {
            outputArea.append("O ano " + ano + " não é bissexto.\n");
        }
    }

    private void faixaEtaria() {
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:"));
        if (idade >= 0 && idade <= 12) {
            outputArea.append("Criança.\n");
        } else if (idade >= 13 && idade <= 17) {
            outputArea.append("Adolescente.\n");
        } else if (idade >= 18 && idade <= 59) {
            outputArea.append("Adulto.\n");
        } else if (idade >= 60) {
            outputArea.append("Idoso.\n");
        } else {
            outputArea.append("Idade inválida.\n");
        }
    }

    private void conceitoNota() {
        double nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota do aluno:"));
        if (nota >= 9) {
            outputArea.append("Conceito A\n");
        } else if (nota >= 7) {
            outputArea.append("Conceito B\n");
        } else if (nota >= 5) {
            outputArea.append("Conceito C\n");
        } else if (nota >= 3) {
            outputArea.append("Conceito D\n");
        } else {
            outputArea.append("Conceito F\n");
        }
    }

    private void categoriaProduto() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
        if (codigo >= 1 && codigo <= 10) {
            outputArea.append("Alimento não-perecível\n");
        } else if (codigo >= 11 && codigo <= 20) {
            outputArea.append("Alimento perecível\n");
        } else if (codigo >= 21 && codigo <= 30) {
            outputArea.append("Vestuário\n");
        } else if (codigo >= 31 && codigo <= 40) {
            outputArea.append("Eletrônicos\n");
        } else {
            outputArea.append("Código inválido\n");
        }
    }

    private void operacaoMatematica() {
        double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
        double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
        String operacao = JOptionPane.showInputDialog("Digite a operação (adição, subtração, multiplicação, divisão):");
        switch (operacao) {
            case "adição":
                outputArea.append("Resultado: " + (numero1 + numero2) + "\n");
                break;
            case "subtração":
                outputArea.append("Resultado: " + (numero1 - numero2) + "\n");
                break;
            case "multiplicação":
                outputArea.append("Resultado: " + (numero1 * numero2) + "\n");
                break;
            case "divisão":
                if (numero2 != 0) {
                    outputArea.append("Resultado: " + (numero1 / numero2) + "\n");
                } else {
                    outputArea.append("Erro: Divisão por zero.\n");
                }
                break;
            default:
                outputArea.append("Operação inválida\n");
                break;
        }
    }

    private void intervalo10a20() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));
        if (numero >= 10 && numero <= 20) {
            outputArea.append("O número " + numero + " está no intervalo de 10 a 20.\n");
        } else {
            outputArea.append("O número " + numero + " não está no intervalo de 10 a 20.\n");
        }
    }

    private void maiorQue100() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));
        if (numero > 100) {
            outputArea.append("O número " + numero + " é maior que 100.\n");
        } else {
            outputArea.append("O dobro do número é: " + (numero * 2) + "\n");
        }
    }

    private void descontoCategoria() {
        double valorCompra = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da compra:"));
        int categoria = Integer.parseInt(JOptionPane.showInputDialog("Digite a categoria do cliente (1: Comum, 2: Associado, 3: VIP):"));
        double desconto = 0;
        switch (categoria) {
            case 1:
                desconto = 0;
                break;
            case 2:
                desconto = 0.10;
                break;
            case 3:
                desconto = 0.20;
                break;
            default:
                outputArea.append("Categoria inválida.\n");
                return;
        }
        double valorFinal = valorCompra * (1 - desconto);
        outputArea.append("O valor final da compra é: " + valorFinal + "\n");
    }

    private void raizQuadrado() {
        double numero = Double.parseDouble(JOptionPane.showInputDialog("Digite um número:"));
        if (numero > 0) {
            outputArea.append("Raiz quadrada: " + Math.sqrt(numero) + "\n");
        } else {
            outputArea.append("Número ao quadrado: " + (numero * numero) + "\n");
        }
    }

    private void calcularIMC() {
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso (kg):"));
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura (m):"));
        double imc = peso / (altura * altura);
        outputArea.append("IMC: " + imc + "\n");
        if (imc < 18.5) {
            outputArea.append("Abaixo do peso.\n");
        } else if (imc < 24.9) {
            outputArea.append("Peso normal.\n");
        } else if (imc < 29.9) {
            outputArea.append("Sobrepeso.\n");
        } else if (imc < 34.9) {
            outputArea.append("Obesidade grau I.\n");
        } else if (imc < 39.9) {
            outputArea.append("Obesidade grau II.\n");
        } else {
            outputArea.append("Obesidade grau III.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AtividadeProaJava().setVisible(true);
        });
    }
}
