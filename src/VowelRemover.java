import java.util.List;

public class VowelRemover {
  public static String removeVowels(String input) {
    // TODO: Implement the vowel removal logic here
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    List<Character> vowel = List.of('a', 'e', 'i', 'o', 'u');
    StringBuilder sbr = new StringBuilder();

    for(int index = 0; index < input.length() ; index++ ) {
      //65 - 90 upper case
      //97 - 122 lower case
      char c = input.charAt(index);
      c = Character.toLowerCase(c);
        if(!vowel.contains(c)) {
          sbr.append(input.charAt(index));
        }
    }
// outer O(n), binary search : nlog n
// n^2
    return sbr.toString();
  }

  public static void main(String[] args) {
    // Test cases¬¬
    System.out.println(removeVowels("Hello World")); // Hll Wrld
    System.out.println(removeVowels("JAVA Programming")); // JV Prgrmmng
  }
}

/**
 *
 * transaction (transaction_id, amount, timestamp, terminal_id, merchant_id)
 * merchant (merchant_id, name, shop_address)
 * latest 10 transactions for a particular merchant_id
 * Report: no_of_transaction for last month : each merchant
 * { {1000, M123}, {2000, M234} }
 *
 * select count(transaction_id) TRANS_COUNT, merchant_id , timestamp
 * from transaction
 * group by merchant_id
 * having timestamp > SYSDATE - 60 and timestamp < SYSDATE - 30;
 *
 * to_Date(timestamp,
 *
 * select transacton_id, amount
 * from transaction
 * where merchant_id = :merchantId
 * order by timestamp desc
 * limit 10;
 *
 * select m.name, t.transacton_id, t.amount
 * from transaction t join merchant m on t.merchant_id = m.merchant_id
 * where merchant_id = :merchantId
 * order by timestamp desc
 * limit 10;
 */