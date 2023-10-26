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
    private String NomeDoEmpreendimento;

    private Boolean CNPJ;

    private String TipoDeEmpreendimento;

    private int TelefoneParaContato;

    private String Endereco;

    private String RedesSocias;

    private String NomeCompletoDoResponsavelPorCadastrar;

    private String Cargo;

    private String SenhaDeAcesso;

    public Mercado build() {

        return Mercado.builder()
            .NomeDoEmpreendimento(NomeDoEmpreendimento)
            .CNPJ(CNPJ)
            .TipoDeEmpreendimento(TipoDeEmpreendimento)
            .TelefoneParaContato(TelefoneParaContato)
            .Endereco(Endereco)
            .RedesSocias(RedesSocias)
            .NomeCompletoDoResponsavelPorCadastrar(NomeCompletoDoResponsavelPorCadastrar)
            .Cargo(Cargo)
            .SenhaDeAcesso(SenhaDeAcesso)
            .build();
      }
}