public class Truqueiro extends Jogador {

    public Truqueiro(String nome) {
        super(nome);
    }

    @Override
    public Carta jogada(Carta cartaNaMesa) {
        // vai jogar a maior carta se nao tiver cartas na mesa
        if (cartaNaMesa == null) {
            return jogaMaiorCarta();
        }

        // vai jogar uma carta pra tentar ganhar das cartas da mesa
        for (Carta carta : cartas) {
            if (carta.valor > cartaNaMesa.valor) {
                return jogaCarta(carta);
            }
        }

        // descarta a carta
        return jogaMenorCarta();
    }

    private Carta jogaMaiorCarta() {
        Carta maiorCarta = cartas.get(0);
        for (Carta carta : cartas) {
            if (carta.valor > maiorCarta.valor) {
                maiorCarta = carta;
            }
        }
        cartas.remove(maiorCarta);
        return maiorCarta;
    }

    private Carta jogaMenorCarta() {
        Carta menorCarta = cartas.get(0);
        for (Carta carta : cartas) {
            if (carta.valor < menorCarta.valor) {
                menorCarta = carta;
            }
        }
        cartas.remove(menorCarta);
        return menorCarta;
    }

    private Carta jogaCarta(Carta carta) {
        cartas.remove(carta);
        return carta;
    }
}