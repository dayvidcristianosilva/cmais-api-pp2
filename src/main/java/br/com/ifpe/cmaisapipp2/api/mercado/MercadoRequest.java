package br.com.ifpe.cmaisapipp2.api.mercado;

import br.com.ifpe.cmaisapipp2.modelo.mercado.Mercado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MercadoRequest {
    private String nomeEmpreendimento;

    private String tipoEmpreendimento;

    private String telefoneContato;

    private String endereco;

    private String redesSociais;

    private String nomeCompletoResponsavel;

    private String cargoResponsavel;

    private String senhaDeAcesso;

    public Mercado build() {

        return Mercado.builder()
                .nomeEmpreendimento(nomeEmpreendimento)
                .tipoEmpreendimento(tipoEmpreendimento)
                .telefoneContato(telefoneContato)
                .endereco(endereco)
                .redesSociais(redesSociais)
                .nomeCompletoResponsavel(nomeCompletoResponsavel)
                .cargoResponsavel(cargoResponsavel)
                .senhaDeAcesso(senhaDeAcesso)
                .build();
    }
}