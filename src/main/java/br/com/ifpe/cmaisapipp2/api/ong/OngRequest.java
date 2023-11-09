package br.com.ifpe.cmaisapipp2.api.ong;

import java.time.LocalDate;

import br.com.ifpe.cmaisapipp2.modelo.ong.Ong;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OngRequest {

    private String NomeInstituicao;

    private String CNPJInstituicao;

    private String EnderecoInstituicao;

    private String TelefoneInstituicao;

    private LocalDate DataConstituicao;

    private String EmailInstituicao;

    private String RedesSociaisIntituicao;

    private String ComprovanteCadastro;

    private String NomeResponsavel;

    private String CpfReponsavel;

    private String TelefoneResponsavel;

    private String EmailResponsavel;

    private String CargoReponsavel;

    private String SenhaAcesso;

    public Ong build() {

        return Ong.builder()
                .NomeInstituicao(NomeInstituicao)
                .CNPJInstituicao(CNPJInstituicao)
                .EnderecoInstituicao(EnderecoInstituicao)
                .TelefoneInstituicao(TelefoneInstituicao)
                .DataConstituicao(DataConstituicao)
                .EmailInstituicao(EmailInstituicao)
                .RedesSociaisIntituicao(RedesSociaisIntituicao)
                .ComprovanteCadastro(ComprovanteCadastro)
                .NomeResponsavel(NomeResponsavel)
                .CpfReponsavel(CpfReponsavel)
                .TelefoneResponsavel(TelefoneResponsavel)
                .EmailResponsavel(EmailResponsavel)
                .CargoReponsavel(CargoReponsavel)
                .SenhaAcesso(SenhaAcesso)
                .build();
    }

}
