import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

        String[] candidatos = {"GUSTAVO", "DIANA", "NÚBIA", "DOUGLAS", "BEA"};

        for(String candidato : candidatos){
            entrarEmContato(candidato);
        }

    }

    static void entrarEmContato(String candidato){
        int tentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando){
                tentativas++;
            }else{
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        }while(continuarTentando && tentativas < 3);

        if(atendeu){
            System.out.printf("Conseguimos contato com %s na %dº tentativa", candidato, tentativas);
            System.out.println();
        }else{
            System.out.printf("Não conseguimos contato com %s, número máximo de tentativas atingido ", candidato);
            System.out.println();
        }
    }

    static void imprimirSelecionados(){
        String[] candidatos = {"GUSTAVO", "DIANA", "NÚBIA", "DOUGLAS", "BEA"};

        for(int i = 0; i < candidatos.length; i++) {
            System.out.printf("O candidato selecionado de Nº %d é %s", (i+1), candidatos[i]);
            System.out.println();
        }

        System.out.println();

        for(String candidato : candidatos){
            System.out.printf("O candidato selecionado foi: %s", candidato);
            System.out.println();
        }
    }

    static void selecaoCandidatos(){
        String[] candidatos = {"GUSTAVO", "DIANA", "NÚBIA", "DOUGLAS", "BEA", "LUCIO", "MARIO", "PAULA", "DIEGO", "KLEBINHA"};

        int selecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(selecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato %s solicitou este valor de salário: %.1f", candidato, salarioPretendido);
            System.out.println();
            if(salarioBase >= salarioPretendido){
                System.out.printf("O candidato %s foi selecionado para a vaga", candidato);
                System.out.println();
                selecionados++;
            }
            candidatoAtual++;
        }

    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }


    static void analisarCandidato(double salarioPretendido){

        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido ){
            System.out.println("Ligar para o candidato");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }else{
            System.out.println("Aguardando o resultado dos demais candidatos");
        }

    }

}
