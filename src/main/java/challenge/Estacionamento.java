package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    List<Carro> estaciomento = new ArrayList<>();


    public void estacionar(Carro carro) {
        if(carro.getMotorista().getIdade()<18)throw new EstacionamentoException("Nao permitido motorista menor");
        if(estaciomento.size()>9) {
            Carro carroEscolhido = estaciomento.stream()
                    .filter(veiculo -> veiculo.getMotorista().getIdade() <= 55)
                    .findFirst()
                    .orElseThrow(() -> new EstacionamentoException("Estacionamento lotado"));
            estaciomento.remove(carroEscolhido);
        }

        estaciomento.add(carro);

    System.out.println(carro);




    }

    public int carrosEstacionados() {
        System.out.println(estaciomento.size());
        return estaciomento.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return estaciomento.contains(carro);
    }
}
