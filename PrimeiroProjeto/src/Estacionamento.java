import java.util.Scanner;

public class Estacionamento  {

    // Enum para os tipos de veículos e seus preços por hora
    enum TipoVeiculo {
        CARRO(10.0),
        MOTO(5.0),
        CAMINHAO(15.0);

        private final double precoPorHora;

        TipoVeiculo(double precoPorHora) {
            this.precoPorHora = precoPorHora;
        }

        public double getPrecoPorHora() {
            return precoPorHora;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar o tipo de veículo ao usuário
        System.out.println("Digite o tipo de veículo (CARRO, MOTO, CAMINHAO):");
        String tipoVeiculoInput = scanner.next().toUpperCase();

        // Solicitar a quantidade de horas estacionadas
        System.out.println("Digite a quantidade de horas estacionadas:");
        int horas = scanner.nextInt();

        // Verificar se o tipo de veículo é válido e calcular o valor total
        try {
            TipoVeiculo tipoVeiculo = TipoVeiculo.valueOf(tipoVeiculoInput);
            double valorTotal = calcularValor(tipoVeiculo, horas);
            System.out.printf("Valor total: R$ %.2f%n", valorTotal);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de veículo inválido. Por favor, digite CARRO, MOTO ou CAMINHAO.");
        }

        scanner.close();
    }

    // Método para calcular o valor total a ser pago
    public static double calcularValor(TipoVeiculo tipoVeiculo, int horas) {
        return tipoVeiculo.getPrecoPorHora() * horas;
    }
}



