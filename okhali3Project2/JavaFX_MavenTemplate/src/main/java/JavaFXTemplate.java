import Models.*;
import Services.ThreeCardLogic;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;
import java.util.List;


public class JavaFXTemplate extends Application {


    private static ThreeCardPokerGame game;


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        game = new ThreeCardPokerGame();
        game.setTheDealer(new Dealer());
        if (game.getTheDealer().getTheDeck().size() < 34) {
            game.getTheDealer().setTheDeck(new Deck());
        }
        //Player1 hand
        ArrayList<Card> playerOneHand = game.getTheDealer().dealHand();
        Player playerOne = new Player();
        playerOne.setHand(playerOneHand);
        game.setPlayerOne(playerOne);
        ThreeCardLogic.evalHand(playerOneHand);
        if (game.getTheDealer().getTheDeck().size() < 34) {
            game.getTheDealer().setTheDeck(new Deck());
        }

        //Player2 hand
        ArrayList<Card> playerTwoHand = game.getTheDealer().dealHand();
        Player playerTwo = new Player();
        playerTwo.setHand(playerTwoHand);
        game.setPlayerTwo(playerTwo);
        ThreeCardLogic.evalHand(playerTwoHand);
        if (game.getTheDealer().getTheDeck().size() < 34) {
            game.getTheDealer().setTheDeck(new Deck());
        }

        //Dealer hand
        ArrayList<Card> dealerHand = game.getTheDealer().dealHand();
        game.getTheDealer().setDealersHand(dealerHand);
        ThreeCardLogic.evalHand(dealerHand);
        if (game.getTheDealer().getTheDeck().size() < 34) {
            game.getTheDealer().setTheDeck(new Deck());
        }
        System.out.println(game.getTheDealer().getTheDeck());
        launch(args);
    }


    //feel free to remove the starter code from this method
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("Welcome to Project #2");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Panes
        Pane dealerPane = new Pane();
        Pane playerOnePane = new Pane();
        Pane playerTwoPane = new Pane();
        Pane playerOneBetsPane = new Pane();
        Pane playerTwoBetsPane = new Pane();

        //Set Size
        dealerPane.setPrefSize(800, 400);
        playerOnePane.setPrefSize(400, 200);
        playerTwoPane.setPrefSize(400, 200);
        playerOneBetsPane.setPrefSize(250, 400);
        playerTwoBetsPane.setPrefSize(250, 400);

        //Set Color
        playerOnePane.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0), Insets.EMPTY)));
        playerTwoPane.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));
        playerOneBetsPane.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(0), Insets.EMPTY)));
        playerTwoBetsPane.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(0), Insets.EMPTY)));
        dealerPane.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY)));


        /*
         * TOP LEFT - Dealer Pane
         *
         *
         * */
        Pane cardOnePane = new Pane();
        Pane cardTwoPane = new Pane();
        Pane cardThreePane = new Pane();
        Image cardOne = new Image("pngs/back.png");
        ImageView cardOneView = new ImageView(cardOne);
        cardOneView.setFitHeight(200);
        cardOneView.setFitWidth(160);
        Image cardTwo = new Image("pngs/back1.png");
        ImageView cardTwoView = new ImageView(cardTwo);
        cardTwoView.setFitHeight(200);
        cardTwoView.setFitWidth(160);
        Image cardThree = new Image("pngs/back2.png");
        ImageView cardThreeView = new ImageView(cardThree);
        cardThreeView.setFitHeight(200);
        cardThreeView.setFitWidth(160);
        cardOnePane.getChildren().add(cardOneView);
        cardTwoPane.getChildren().add(cardTwoView);
        cardThreePane.getChildren().add(cardThreeView);


        //cardOnePane.setPrefSize(111,167);
        //cardTwoPane.setPrefSize(200, 250);
        //cardThreePane.setPrefSize(200, 250);

        cardOnePane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
        cardTwoPane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
        cardThreePane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));

        List<Pane> dealerCards = new ArrayList<Pane>();
        dealerCards.add(cardOnePane);
        dealerCards.add(cardTwoPane);
        dealerCards.add(cardThreePane);
        HBox dealerCardBox = new HBox(dealerCards.get(0), dealerCards.get(1), dealerCards.get(2));
        dealerCardBox.resize(50, 80);
        dealerCardBox.setAlignment(Pos.CENTER);
        dealerCardBox.setSpacing(20);

        Text dealerTitle = new Text("Three Card Poker Game");
        dealerTitle.setTextAlignment(TextAlignment.CENTER);
        dealerTitle.setFill(Color.WHITE);
        dealerTitle.setFont(Font.font("Verdana", 20));

        Text dealerHandText = new Text("Dealer Hand:");
        dealerHandText.setTextAlignment(TextAlignment.CENTER);
        dealerHandText.setFill(Color.WHITE);
        dealerHandText.setFont(Font.font("Verdana", 14));

        Button showButton = new Button("SHOW");
        Button dealButton = new Button("DEAL");

        VBox dealerBox = new VBox(dealerTitle, dealerHandText, dealerCardBox, showButton, dealButton);
        dealerBox.setSpacing(20);
        dealerBox.setAlignment(Pos.TOP_CENTER);
        showButton.setAlignment(Pos.BOTTOM_RIGHT);


        dealerBox.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));


        TextField textField2 = new TextField();

        /*
         * Top Right - Player 1 bets
         *
         *
         * */

        TextField p1AnteBetAmount = new TextField("Ante Bet");
        TextField p1PairPlusBetAmount = new TextField("PairPlus Bet");
        TextField p1PlayBetAmount = new TextField("Place bet");

        TextField p2AnteBetAmount = new TextField("Ante Bet");
        TextField p2PairPlusBetAmount = new TextField("PairPlus Bet");
        TextField p2PlayBetAmount = new TextField("Place bet");

        Button p2AnteBetButton = new Button("Bet");
        p2AnteBetButton.setDisable(true);
        Button p2PairPlusBetButton = new Button("Bet");
        p2PairPlusBetButton.setDisable(true);
        Button p2PlayBetButton = new Button("Bet");
        p2PlayBetButton.setDisable(true);

        Button p1AnteBetButton = new Button("Bet");
        p1AnteBetButton.setOnAction(e -> {
            if(Integer.parseInt(p1AnteBetAmount.getText()) >= 5 && Integer.parseInt(p1AnteBetAmount.getText()) <= 25){
                game.getPlayerOne().setAnteBet(Integer.parseInt(p1AnteBetAmount.getText()));
            }
            p2AnteBetButton.setDisable(false);
            p2PairPlusBetButton.setDisable(false);
        });
        Button p1PairPlusBetButton = new Button("Bet");
        p1PairPlusBetButton.setOnAction(e -> {
            if(Integer.parseInt(p1PairPlusBetAmount.getText()) >= 5 && Integer.parseInt(p1PairPlusBetAmount.getText()) <= 25){
                game.getPlayerOne().setPairPlusBet(Integer.parseInt(p1PairPlusBetAmount.getText()));
            }
        });
        Button p1PlayBetButton = new Button("Bet");
        p1PlayBetButton.setOnAction(e -> {
            game.getPlayerTwo().setPlayBet(Integer.parseInt(p1PlayBetAmount.getText()));
        });
        p1PlayBetButton.setDisable(true);

        Text anteText = new Text("Ante Bet:$ ");
        Text pairPlusText = new Text("PairPlus Bet:$ ");
        Text playWagerText = new Text("Play Wager:$ ");
        Text totalText = new Text("Total:$ ");


        HBox p1AnteBox = new HBox(p1AnteBetAmount, p1AnteBetButton);
        HBox p1PairPlusBox = new HBox(p1PairPlusBetAmount, p1PairPlusBetButton);
        HBox p1PlayBetBox = new HBox(p1PlayBetAmount, p1PlayBetButton);

        VBox playerOneBetBox = new VBox(p1AnteBox, p1PairPlusBox, p1PlayBetBox);
        playerOneBetBox.setPadding(new Insets(20));
        playerOneBetBox.setSpacing(20);
        playerOneBetBox.setAlignment(Pos.CENTER);
        playerOneBetBox.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));


        /*
         * Bottom Right - Player 2 bets
         *
         *
         * */

        p2AnteBetButton.setOnAction(e -> {
            if(Integer.parseInt(p2AnteBetAmount.getText()) >= 5 && Integer.parseInt(p2AnteBetAmount.getText()) <= 25){
                game.getPlayerTwo().setAnteBet(Integer.parseInt(p2AnteBetAmount.getText()));
            }
        });

        p2PairPlusBetButton.setOnAction(e -> {
            if(Integer.parseInt(p2PairPlusBetAmount.getText()) >= 5 && Integer.parseInt(p2PairPlusBetAmount.getText()) <= 25){
                game.getPlayerTwo().setPairPlusBet(Integer.parseInt(p2PairPlusBetAmount.getText()));
            }
        });

        p2PlayBetButton.setOnAction(e -> {
            game.getPlayerTwo().setPlayBet(Integer.parseInt(p2PlayBetAmount.getText()));
        });
        p2PlayBetButton.setDisable(true);

        Text p2AnteText = new Text("Ante Bet:$ ");
        Text p2PairPlusText = new Text("PairPlus Bet:$ ");
        Text p2PlayWagerText = new Text("Play Wager:$ ");
        Text p2TotalText = new Text("Total:$ ");


        HBox p2AnteBox = new HBox(p2AnteBetAmount, p2AnteBetButton);
        HBox p2PairPlusBox = new HBox(p2PairPlusBetAmount, p2PairPlusBetButton);
        HBox p2PlayBetBox = new HBox(p2PlayBetAmount, p2PlayBetButton);

        VBox playerTwoBetBox = new VBox(p2AnteBox, p2PairPlusBox,p2PlayBetBox);
        playerTwoBetBox.setPadding(new Insets(20));
        playerTwoBetBox.setSpacing(20);
        playerTwoBetBox.setAlignment(Pos.CENTER);
        playerTwoBetBox.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));


        /*
         * Bottom Left - Player Hands
         *
         *
         * */


        HBox playerBox = new HBox();
        playerBox.setPadding(new Insets(50));
        playerBox.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));
        playerBox.setAlignment(Pos.CENTER);
        playerBox.setSpacing(80);

        dealButton.setOnAction(e -> {
            p1PlayBetButton.setDisable(false);
            p2PlayBetButton.setDisable(false);

            //Player 1 cards
            Pane p1CardOnePane = new Pane();
            Pane p1CardTwoPane = new Pane();
            Pane p1CardThreePane = new Pane();
            Image p1CardOne = new Image("pngs/" +
                    String.valueOf(game.getPlayerOne().getHand().get(0).getSuit())
                    + String.valueOf(game.getPlayerOne().getHand().get(0).getValue())+ ".png");
            ImageView p1CardOneView = new ImageView(p1CardOne);
            p1CardOneView.setFitHeight(100);
            p1CardOneView.setFitWidth(60);
            Image p1CardTwo = new Image("pngs/" +
                    String.valueOf(game.getPlayerOne().getHand().get(1).getSuit())
                    + String.valueOf(game.getPlayerOne().getHand().get(1).getValue())+ ".png");
            ImageView p1CardTwoView = new ImageView(p1CardTwo);
            p1CardTwoView.setFitHeight(100);
            p1CardTwoView.setFitWidth(60);
            Image p1CardThree = new Image("pngs/" +
                    String.valueOf(game.getPlayerOne().getHand().get(2).getSuit())
                    + String.valueOf(game.getPlayerOne().getHand().get(2).getValue())+ ".png");
            ImageView p1CardThreeView = new ImageView(p1CardThree);
            p1CardThreeView.setFitHeight(100);
            p1CardThreeView.setFitWidth(60);
            p1CardOnePane.getChildren().add(p1CardOneView);
            p1CardTwoPane.getChildren().add(p1CardTwoView);
            p1CardThreePane.getChildren().add(p1CardThreeView);

            p1CardOnePane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
            p1CardTwoPane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
            p1CardThreePane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));

            Text playerOneText = new Text("Player 1");
            Text playerTwoText = new Text("Player 2");

            List<Pane> playerOneCards = new ArrayList<Pane>();
            playerOneCards.add(p1CardOnePane);
            playerOneCards.add(p1CardTwoPane);
            playerOneCards.add(p1CardThreePane);
            HBox playerOneCardBox = new HBox(playerOneCards.get(0), playerOneCards.get(1), playerOneCards.get(2));
            playerOneCardBox.resize(50, 80);
            playerOneCardBox.setAlignment(Pos.CENTER);
            playerOneCardBox.setSpacing(20);

            VBox playerOneBox = new VBox(playerOneText, playerOneCardBox);
            playerOneBox.setSpacing(20);
            playerOneBox.setAlignment(Pos.CENTER);


            //Player 2 cards
            Pane p2CardOnePane = new Pane();
            Pane p2CardTwoPane = new Pane();
            Pane p2CardThreePane = new Pane();
            Image p2CardOne = new Image("pngs/" +
                    String.valueOf(game.getPlayerTwo().getHand().get(0).getSuit())
                    + String.valueOf(game.getPlayerTwo().getHand().get(0).getValue())+ ".png");
            ImageView p2CardOneView = new ImageView(p2CardOne);
            p2CardOneView.setFitHeight(100);
            p2CardOneView.setFitWidth(60);
            Image p2CardTwo = new Image("pngs/" +
                    String.valueOf(game.getPlayerTwo().getHand().get(1).getSuit())
                    + String.valueOf(game.getPlayerTwo().getHand().get(1).getValue())+ ".png");
            ImageView p2CardTwoView = new ImageView(p2CardTwo);
            p2CardTwoView.setFitHeight(100);
            p2CardTwoView.setFitWidth(60);
            Image p2CardThree = new Image("pngs/" +
                    String.valueOf(game.getPlayerTwo().getHand().get(2).getSuit())
                    + String.valueOf(game.getPlayerTwo().getHand().get(2).getValue())+ ".png");
            ImageView p2CardThreeView = new ImageView(p2CardThree);
            p2CardThreeView.setFitHeight(100);
            p2CardThreeView.setFitWidth(60);
            p2CardOnePane.getChildren().add(p2CardOneView);
            p2CardTwoPane.getChildren().add(p2CardTwoView);
            p2CardThreePane.getChildren().add(p2CardThreeView);

            p2CardOnePane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
            p2CardTwoPane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
            p2CardThreePane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));

            List<Pane> playerTwoCards = new ArrayList<Pane>();
            playerTwoCards.add(p2CardOnePane);
            playerTwoCards.add(p2CardTwoPane);
            playerTwoCards.add(p2CardThreePane);
            HBox playerTwoCardBox = new HBox(playerTwoCards.get(0), playerTwoCards.get(1), playerTwoCards.get(2));
            playerTwoCardBox.resize(50, 80);
            playerTwoCardBox.setAlignment(Pos.CENTER);
            playerTwoCardBox.setSpacing(20);

            VBox playerTwoBox = new VBox(playerTwoText, playerTwoCardBox);
            playerTwoBox.setSpacing(20);
            playerTwoBox.setAlignment(Pos.CENTER);

            HBox playerBox2 = new HBox(playerOneBox, playerTwoBox);
            playerBox2.setPadding(new Insets(50));
            playerBox2.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));
            playerBox2.setAlignment(Pos.CENTER);
            playerBox2.setSpacing(80);

            GridPane gridPane2 = new GridPane();

            gridPane2.setMinSize(1300, 700);
            gridPane2.setPadding(new Insets(10, 10, 10, 10));
            gridPane2.setVgap(5);
            gridPane2.setHgap(5);
            gridPane2.setAlignment(Pos.CENTER);

            gridPane2.add(dealerBox, 0, 0);
            gridPane2.add(playerBox2, 0, 1);
            gridPane2.add(playerOneBetBox, 1, 0);
            gridPane2.add(playerTwoBetBox, 1, 1);

            //Creating a scene object
            Scene scene = new Scene(gridPane2);

            primaryStage.setScene(scene);

            primaryStage.show();
        });


        showButton.setOnAction(e -> {
            ImageView cardOnePaneView = new ImageView(new Image("pngs/" +
                    String.valueOf(game.getTheDealer().getDealersHand().get(0).getSuit())
                    + String.valueOf(game.getTheDealer().getDealersHand().get(0).getValue())+ ".png"));
            cardOnePaneView.setFitHeight(200);
            cardOnePaneView.setFitWidth(160);
            cardOnePane.getChildren().add(cardOnePaneView);
            ImageView cardTwoPaneView = new ImageView(new Image("pngs/" +
                    String.valueOf(game.getTheDealer().getDealersHand().get(1).getSuit())
                    + String.valueOf(game.getTheDealer().getDealersHand().get(1).getValue())+ ".png"));
            cardTwoPaneView.setFitHeight(200);
            cardTwoPaneView.setFitWidth(160);
            cardTwoPane.getChildren().add(cardTwoPaneView);
            ImageView cardThreePaneView = new ImageView(new Image("pngs/" +
                    String.valueOf(game.getTheDealer().getDealersHand().get(2).getSuit())
                    + String.valueOf(game.getTheDealer().getDealersHand().get(2).getValue())+ ".png"));
            cardThreePaneView.setFitHeight(200);
            cardThreePaneView.setFitWidth(160);
            cardThreePane.getChildren().add(cardThreePaneView);

            p1AnteBetButton.setDisable(true);
            p1PairPlusBetButton.setDisable(true);
            p1PlayBetButton.setDisable(true);
            p2AnteBetButton.setDisable(true);
            p2PairPlusBetButton.setDisable(true);
            p2PlayBetButton.setDisable(true);

            Popup popup = new Popup();
            int p1CompVal = ThreeCardLogic.compareHands(game.getTheDealer().getDealersHand() ,game.getPlayerOne().getHand());
            int p2CompVal = ThreeCardLogic.compareHands(game.getTheDealer().getDealersHand() ,game.getPlayerOne().getHand());

            game.getPlayerOne().setTotalWinnings(ThreeCardLogic.evalPPWinnings(game.getPlayerOne().getHand(), game.getPlayerOne().getPairPlusBet()));
            game.getPlayerTwo().setTotalWinnings(ThreeCardLogic.evalPPWinnings(game.getPlayerTwo().getHand(), game.getPlayerTwo().getPairPlusBet()));

            StringBuilder p1Sb = new StringBuilder();
            StringBuilder p2Sb = new StringBuilder();

            if(p1CompVal == 0) {
                p1Sb.append("There was a tie!\n");
            } else if(p1CompVal == 1){
                p1Sb.append("The dealer won!\n");
            } else if(p1CompVal == 2){
                p1Sb.append("The player won!\n");
            }

            if(p2CompVal == 0) {
                p2Sb.append("There was a tie!\n");
            } else if(p2CompVal == 1){
                p2Sb.append("The dealer won!\n");
            } else if(p2CompVal == 2){
                p2Sb.append("The player won!\n");
            }

            StringBuilder winningsSb = new StringBuilder();
            winningsSb.append("Player 1 winnings: " + game.getPlayerOne().getTotalWinnings() +"\n");
            winningsSb.append("Player 2 winnings: " + game.getPlayerTwo().getTotalWinnings() +"\n");

            Label newLabel = new Label("Between player 1 and dealers hand: " + p1Sb+
                    "Between player 2 and dealers hand: " + p2Sb + winningsSb);
            newLabel.setAlignment(Pos.CENTER);

            newLabel.setMinWidth(150);
            newLabel.setMinHeight(100);
            newLabel.relocate(200,200);
            newLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
            popup.getContent().add(newLabel);
            popup.show(primaryStage);

        });

        /*
         * Scene
         *
         *
         * */

        gridPane.setMinSize(1300, 700);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(dealerBox, 0, 0);
        gridPane.add(playerBox, 0, 1);
        gridPane.add(playerOneBetBox, 1, 0);
        gridPane.add(playerTwoBetBox, 1, 1);

        //Creating a scene object
        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
