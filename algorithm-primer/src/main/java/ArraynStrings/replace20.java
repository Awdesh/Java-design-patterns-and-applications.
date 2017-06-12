public class replace20
{
    public String ReplaceFun(String str, int length)
    {
        char[] charArray = str.toCharArray();
        int spaceCount = 0;
        for(int i = 0; i < length; i++)
        {
            if(charArray[i] == ' ')
                spaceCount++;
        }

        // Since length already contains space thus we need 2 more additional characters,
        // because of that we multiply by 2 not 3.
        int newLength = length + spaceCount * 2;
        for(int i = length  - 1; i >= 0;i--)
        {
            if(charArray[i] != ' ')
            {
                charArray[newLength - 1] = charArray[i];
                newLength = newLength - 1;
            }
            else
            {
                charArray[newLength - 1] = '0';
                charArray[newLength - 2] = '2';
                charArray[newLength - 3] = '%';
                newLength = newLength - 3;
            }
        }

        return charArray.toString();

    }
}