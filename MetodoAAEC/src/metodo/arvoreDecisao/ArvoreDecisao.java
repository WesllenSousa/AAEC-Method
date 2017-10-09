package metodo.arvoreDecisao;

import java.util.Random;
import telas.Logs;
import telas.UmaAtividade;
import weka.core.Instances;
import weka.core.Instance;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomTree;
import weka.core.Attribute;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * A little demo java program for using WEKA.<br/>
 * Check out the Evaluation class for more details.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @see Evaluation
 */
public class ArvoreDecisao {

    public String caminhoDados;

    private Logs logs;
    private UmaAtividade umaAtividade;

    // As instancias do dado
    public Instances dados;

    public ArvoreDecisao(String caminhoDados) {
        this.caminhoDados = caminhoDados;
    }

    public ArvoreDecisao(String caminhoDados, Logs logs) {
        this.caminhoDados = caminhoDados;
        this.logs = logs;
    }

    public ArvoreDecisao(String caminhoDados, UmaAtividade umaAtividade) {
        this.caminhoDados = caminhoDados;
        this.umaAtividade = umaAtividade;
    }

    public void lerDados() throws Exception {
        DataSource fonte = new DataSource(caminhoDados);
        dados = fonte.getDataSet();
        //imprime informações associadas à base de dados
        mensagem("Num. instancias:" + dados.numInstances());
        mensagem("Num. atributos:" + dados.numAttributes());
        // seta o atributo classe caso o formato de dados nao contenha essa informacao
        if (dados.classIndex() == -1) {
            dados.setClassIndex(dados.numAttributes() - 1);
        }
    }

    public void imprimeDados() {
        mensagem("Base de Dados: ");
        // Imprime cada instância (linha) dos dados
        for (int i = 0; i < dados.numInstances(); i++) {
            Instance atual = dados.instance(i);
            mensagem((i + 1) + ": " + atual + "\n");
        }
        //imprime o conteúdo do arquivo   
        mensagem("Conteudo do arquivo");
        mensagem(dados.toString());
    }

    public void avaliacoes(RandomTree tree) throws Exception {
        // Imprime a arvore
        mensagem(tree.toString());
        // Avaliacao cruzada (cross-validation)
        mensagem("\nAvaliacao cruzada:");
        Evaluation avalCruzada = new Evaluation(dados);
        avalCruzada.crossValidateModel(tree, dados, 10, new Random(1));
        mensagem("Instancias corretas: " + avalCruzada.correct() + "\n");
        // Avalia o resultado
        mensagem("\nAvaliacao inicial: ");
        Evaluation avaliacao = new Evaluation(dados);
        avaliacao.evaluateModel(tree, dados);
        mensagem("Instancias corretas: " + avaliacao.correct() + "\n");
        // Neste caso ele imprime o equivalente a uma chamada padrão ao algoritmo, como se
        // estivesse usando a interface gráfica
        mensagem("Chamada de linha de código: \n");
        String[] options = new String[2];
        options[0] = "-t";
        options[1] = caminhoDados;
        mensagem(Evaluation.evaluateModel(tree, options));
    }

    //Cria uma instância da árvore J48 e avalia seu desempenho
    public String reconhecerCategoriaAtividade(Integer day, Integer location, Integer types, Integer sensorId) throws Exception {
        // Cria uma nova instancia da arvore
        RandomTree tree = new RandomTree();
        // Constrói classificador
        tree.buildClassifier(dados);

        avaliacoes(tree);

        mensagem("\nAvaliacao de uma nova instancia: ");
        Instance novaInstancia = new Instance(5);
        novaInstancia.setDataset(dados);
        novaInstancia.setValue(0, day);
        novaInstancia.setValue(1, location);
        novaInstancia.setValue(2, types);
        novaInstancia.setValue(3, sensorId);

        //Os valores de pred obedecem a ordem dos atributos da classe organizados no arquivo arff
        //Nesse caso: Personalneeds = 0.0,Goingout = 1.0,Moving=2.0,Domesticwork=3.0,Cooking=4.0,Leisure=5.0,Educational=6.0
        double predicao = tree.classifyInstance(novaInstancia);

        //imprime a string correspondente ao valor de pred 
        Attribute classe = dados.attribute(4);
        String predClass1 = classe.value((int) predicao);
        mensagem("Classe: " + predClass1 + " = " + predicao);
        return predClass1;
    }

    private void mensagem(String msg) {
        System.out.println(msg);
        if (logs != null) {
            Logs.ta_texto.setText(Logs.ta_texto.getText() + msg + "\n");
        } else if (umaAtividade != null) {
            UmaAtividade.ta_texto.setText(UmaAtividade.ta_texto.getText() + msg + "\n");
        }
    }

    public static void main(String[] args) throws Exception {
        //Lymphoma.arff
        ArvoreDecisao exemplo1 = new ArvoreDecisao("dados_arvore.arff");
        exemplo1.lerDados();
        //exemplo1.imprimeDados();
        exemplo1.reconhecerCategoriaAtividade(6, 3, 70, 94);
    }

}
