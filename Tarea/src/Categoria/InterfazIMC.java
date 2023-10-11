package Categoria;

import javax.swing.*;

import Categoria.IProcesosIMC.ProcesosIMC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazIMC extends JFrame implements ActionListener {

    private JLabel txtPeso;
    private JLabel txtAltura;
    private JButton btnCalcular;
    private JTextField inputPeso;
    private JTextField inputAltura;
    private JLabel miResultado;

    public InterfazIMC() {
        iniciarComponentes();
        setTitle("Calculadora de IMC");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        JPanel miPanel = new JPanel();
        miPanel.setLayout(null);

        txtPeso = new JLabel();
        txtPeso.setText("Peso (kg)");
        txtPeso.setBounds(30, 30, 100, 30);

        txtAltura = new JLabel();
        txtAltura.setText("Altura (m)");
        txtAltura.setBounds(30, 70, 100, 30);

        inputPeso = new JTextField();
        inputPeso.setBounds(140, 30, 100, 30);

        inputAltura = new JTextField();
        inputAltura.setBounds(140, 70, 100, 30);

        miResultado = new JLabel();
        miResultado.setBounds(30, 110, 300, 30);

        btnCalcular = new JButton("Calcular IMC");
        btnCalcular.setBounds(30, 150, 150, 30);
        btnCalcular.addActionListener(this);

        add(miResultado);
        add(btnCalcular);
        add(txtPeso);
        add(txtAltura);
        add(inputPeso);
        add(inputAltura);

        add(miPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            String pesoStr = inputPeso.getText();
            String alturaStr = inputAltura.getText();

            try {
                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                double imc = ProcesosIMC.calcularIMC(peso, altura);
                String resultado = ProcesosIMC.obtenerCategoriaIMC(imc);
                miResultado.setText("Tu IMC es " + imc + ", lo que corresponde a la categoría: " + resultado);
            } catch (NumberFormatException ex) {
                miResultado.setText("Por favor, ingrese valores válidos para peso y altura.");
            }
        }
    }
}
